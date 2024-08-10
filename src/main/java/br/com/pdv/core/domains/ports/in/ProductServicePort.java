package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;

public interface ProductServicePort {
	
	void save(Product product, ProductRequest request);
	void delete(Long idProduct);

}
