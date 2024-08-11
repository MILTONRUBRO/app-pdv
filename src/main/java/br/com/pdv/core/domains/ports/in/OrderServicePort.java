package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.entity.OrderStatus;
import br.com.pdv.adapter.driven.infra.dto.request.OrderRequest;

public interface OrderServicePort {
	
	void create(OrderRequest orderRequest);

	void updateOrderStatus(Long idProduct, OrderStatus status);
}
