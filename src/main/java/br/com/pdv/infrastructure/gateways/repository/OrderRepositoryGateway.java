package br.com.pdv.infrastructure.gateways.repository;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.domain.entity.Customer;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.gateways.mapper.OrderEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.OrderEntity;
import br.com.pdv.infrastructure.persistence.entity.OrderStatus;
import br.com.pdv.infrastructure.persistence.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
public class OrderRepositoryGateway implements OrderGateway {

    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;
    private final CustomerGateway customerGateway;

    public OrderRepositoryGateway(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper, CustomerGateway customerGateway) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
        this.customerGateway = customerGateway;
    }

    @Override
    public Order createOrder(Order order) {
        Customer customer = customerGateway.findByDocument(order.customer().document());
        Order updatedOrder = order.withCustomer(customer);
        OrderEntity orderEntity = orderEntityMapper.toEntity(updatedOrder);
        orderEntity.setData(LocalDateTime.now());
        orderEntity.setStatus(OrderStatus.RECEIVED);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityMapper.toDomainObj(orderEntity);
    }


}
