package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.entity.Order;
import br.com.pdv.adapter.driven.infra.request.OrderRequest;

public interface OrderServicePort {
	
	void create(OrderRequest orderRequest);
	//void delete(Long idProduct);
	//void update(ProductRequest request, Long idProduct);

}
