package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.dto.request.ProductRequest;

public interface ProductServicePort {
	
	void save(ProductEntity product, ProductRequest request);
	void delete(Long idProduct);
	void update(ProductRequest request, Long idProduct);
	ProductEntity findById(Long idProduct)  ;

}
