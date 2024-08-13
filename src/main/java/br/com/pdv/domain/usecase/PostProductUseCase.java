package br.com.pdv.domain.usecase;

import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.inbound.PostProductUseCasePort;
import br.com.pdv.domain.ports.outbound.PostProductAdapterPort;

public class PostProductUseCase implements PostProductUseCasePort{
	
	private final PostProductAdapterPort postProductAdapterPort;

	public PostProductUseCase(PostProductAdapterPort postProductAdapterPort) {
		this.postProductAdapterPort = postProductAdapterPort;
	}

	@Override
	public void save(Product product, ProductRequest request) {
		postProductAdapterPort.save(product, request);
	}

}
