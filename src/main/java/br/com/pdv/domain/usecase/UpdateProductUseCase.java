package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Category;
import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.inbound.UpdateProductUseCasePort;
import br.com.pdv.domain.ports.outbound.GetCategoryByIdAdapterPort;
import br.com.pdv.domain.ports.outbound.UpdateProductAdapterPort;

public class UpdateProductUseCase implements UpdateProductUseCasePort  {
	
	private final GetCategoryByIdAdapterPort getCategoryByIdAdapterPort;
	private final UpdateProductAdapterPort updateProductAdapterPort;

	public UpdateProductUseCase(GetCategoryByIdAdapterPort getCategoryByIdAdapterPort,
			UpdateProductAdapterPort updateProductAdapterPort) {
		this.getCategoryByIdAdapterPort = getCategoryByIdAdapterPort;
		this.updateProductAdapterPort = updateProductAdapterPort;
	}

	@Override
	public void update(Product product, Long idProduct) {
		Category category = getCategoryByIdAdapterPort.getCategoryById(product.getIdCategory());
		updateProductAdapterPort.update(product, idProduct, category);
	}

}
