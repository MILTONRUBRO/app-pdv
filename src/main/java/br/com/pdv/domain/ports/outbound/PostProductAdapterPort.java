package br.com.pdv.domain.ports.outbound;

import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.domain.Product;

public interface PostProductAdapterPort {
	void save(Product product, ProductRequest request);
}
