package br.com.pdv.domain.ports.inbound;

import br.com.pdv.domain.Product;

public interface UpdateProductUseCasePort {
	void update(Product product, Long idProduct);
}
