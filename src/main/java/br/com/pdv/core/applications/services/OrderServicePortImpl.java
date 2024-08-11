package br.com.pdv.core.applications.services;

import br.com.pdv.adapter.driven.infra.entity.OrderStatus;
import br.com.pdv.adapter.driven.infra.mapper.OrderMapper;
import br.com.pdv.adapter.driven.infra.dto.request.OrderRequest;
import br.com.pdv.core.applications.ports.repositories.OrderRepositoryPort;
import br.com.pdv.core.domains.ports.in.CustomerServicePort;
import br.com.pdv.core.domains.ports.in.OrderServicePort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
@AllArgsConstructor
public class OrderServicePortImpl implements OrderServicePort {

	private final CustomerServicePort customerService;
	private final OrderRepositoryPort orderRepository;
	private final OrderMapper orderMapper;


	@Override
	@Transactional
	public void create(OrderRequest request) {
		var customer = customerService.find(request.getDocumentNumber());
		var order = orderMapper.requestMapper(request);
		order.setStatus(OrderStatus.PENDING);
		order.setCustomer(customer);
		order.setData(LocalDateTime.now());
		orderRepository.save(order);
		log.info("Pedido criado {}", order);
	}

	@Override
	@Transactional
	public void updateOrderStatus(Long idOrder, OrderStatus orderStatus) {
		orderRepository.updateOrderStatus(idOrder, orderStatus);
	}


}
