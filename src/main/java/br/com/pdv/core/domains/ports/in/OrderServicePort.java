package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.request.OrderRequest;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;

public interface OrderServicePort {
	
	void create(OrderRequest request);
	//void delete(Long idProduct);
	//void update(ProductRequest request, Long idProduct);

}
