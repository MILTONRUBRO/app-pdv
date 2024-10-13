package br.com.pdv.infrastructure.gateways.repository;

import br.com.pdv.application.exception.NotFoundException;
import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.gateways.ItemOrderGateway;
import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.domain.entity.Customer;
import br.com.pdv.domain.entity.ItemOrder;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.response.OrdersResponse;
import br.com.pdv.infrastructure.gateways.mapper.OrderEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.OrderEntity;
import br.com.pdv.infrastructure.persistence.entity.OrderStatus;
import br.com.pdv.infrastructure.persistence.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
public class OrderRepositoryGateway implements OrderGateway {

    final String IDENTIFICATION_PREFIX = "SEM-IDENTIFICACAO-";
    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;
    private final CustomerGateway customerGateway;
    private final ItemOrderGateway itemOrderGateway;

    public OrderRepositoryGateway(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper, CustomerGateway customerGateway,  ItemOrderGateway itemOrderGateway) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
        this.customerGateway = customerGateway;
        this.itemOrderGateway = itemOrderGateway;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        log.info("Initializing order creation");
        Customer customer = findOrCreateCustomer(order);
        OrderEntity orderEntity = mapAndPrepareOrderEntity(order, customer);
        Long orderId = orderEntity.getId();
        createItes(order, orderId);
        log.info("Order with ID {} created successfully!", orderId);
        return orderEntityMapper.toDomainObj(orderEntity);
    }

    @Override
    public void updateOrderStatus(Long idOrder, String status) {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(idOrder);
        if (!optionalOrder.isPresent()) {
            throw new NotFoundException("Pedido não encontrado");
        }
        optionalOrder.get().setStatus(OrderStatus.fromString(status));
        orderRepository.save(optionalOrder.get());
    }

	@Override
	public String getOrderPaymentSatus(Long idOrder) {
		Optional<OrderEntity> optionalOrder = orderRepository.findById(idOrder);
        
		if (!optionalOrder.isPresent()) {
            throw new NotFoundException("Pedido não encontrado");
        }
		
		return optionalOrder.get().getPaymentStatus().getStatus();
	}

    @Override
    public List<OrdersResponse> getAllOrdersOrdenedInteractor() {
        List<OrderEntity> orders = orderRepository.findByStatusNot(OrderStatus.FINALIZED);
        return orders.stream()
                .sorted(Comparator.comparing(this::getPriority)
                        .thenComparing(OrderEntity::getData))
                .map(orderEntityMapper::toResponse)
                .collect(Collectors.toList());
    }


    private Customer findOrCreateCustomer(Order order) {
        return customerGateway.findByDocumentForOrder(order.customer().document())
                .orElseGet(() -> createAnonymousCustomer(order));
    }

    private OrderEntity mapAndPrepareOrderEntity(Order order, Customer customer) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(order.withCustomer(customer));
        orderEntity.setData(LocalDateTime.now());
        orderEntity.setStatus(OrderStatus.RECEIVED);
        return orderRepository.save(orderEntity);
    }

    private void createItes(Order order, Long orderId) {
        order.itemsOrder().forEach(item -> {
            ItemOrder itemOrder = new ItemOrder(null, orderId, item.productId(), item.quantity());
            itemOrderGateway.addItemOrder(itemOrder);
        });
    }

    private Customer createAnonymousCustomer(Order order) {
        log.info("Creating client anonumous");
        Long nextCustomerId = customerGateway.nextCustomerId();
        return customerGateway.createCustomer(new Customer(
                nextCustomerId,
                IDENTIFICATION_PREFIX + nextCustomerId,
                IDENTIFICATION_PREFIX + nextCustomerId,
                IDENTIFICATION_PREFIX + nextCustomerId
        ));
    }

    private int getPriority(OrderEntity order) {
        return switch (order.getStatus()) {
            case COMPLETED -> 1;
            case PROCESSING -> 2;
            case RECEIVED -> 3;
            default -> 4;
        };
    }
}
