package br.com.pdv.core.applications.services;

import br.com.pdv.adapter.driven.infra.entity.Order;
import br.com.pdv.adapter.driven.infra.entity.OrderStatus;
import br.com.pdv.adapter.driven.infra.request.OrderRequest;
import br.com.pdv.core.applications.exceptions.NotFoundException;
import br.com.pdv.core.applications.ports.repositories.CustomerRepositoryPort;
import br.com.pdv.core.applications.ports.repositories.OrderRepositoryPort;
import br.com.pdv.core.domains.ports.in.OrderServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class OrderServicePortImpl implements OrderServicePort {

	private final CustomerRepositoryPort customerRepository ;
	private final OrderRepositoryPort orderRepositoryPort;


	@Override
	public void create(OrderRequest request) {
		var customer = customerRepository.findById(request.getCustomerId())
				.orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
		Order order = new Order();
		order.setCustomer(customer);
		order.setStatus(OrderStatus.PENDING);
		orderRepositoryPort.save(order);

		log.info("Pedido criado {}", order);
	}


}
