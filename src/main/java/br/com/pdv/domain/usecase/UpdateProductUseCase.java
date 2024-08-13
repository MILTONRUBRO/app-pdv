package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.inbound.UpdateProductUseCasePort;
import br.com.pdv.domain.ports.outbound.UpdateProductAdapterPort;

public class UpdateProductUseCase implements UpdateProductUseCasePort  {
	
	// criar adapter da category 
	private final UpdateProductAdapterPort updateProductAdapterPort;

	public UpdateProductUseCase(UpdateProductAdapterPort updateProductAdapterPort) {
		this.updateProductAdapterPort = updateProductAdapterPort;
	}

	@Override
	public void update(Product product, Long idProduct) {
		Category category = categoryAdapterPort.findCategory();
		updateProductAdapterPort.update(product, idProduct, category);
	}

}
