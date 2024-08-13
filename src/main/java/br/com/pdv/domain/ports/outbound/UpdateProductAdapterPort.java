package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Category;
import br.com.pdv.domain.Product;

public interface UpdateProductAdapterPort {
	void update(Product product, Long idProduct, Category category);
}
