package br.com.pdv.domain.ports.inbound;

import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.domain.Product;

public interface PostProductUseCasePort {
	
	void save(Product product, ProductRequest request);
}
