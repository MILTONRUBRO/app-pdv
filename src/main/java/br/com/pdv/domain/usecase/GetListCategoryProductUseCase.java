package br.com.pdv.domain.usecase;

import br.com.pdv.adapter.inbound.controller.response.CategoryProductResponse;
import br.com.pdv.domain.ports.inbound.GetListCategoryProductUseCasePort;
import br.com.pdv.domain.ports.outbound.GetListCategoryProductAdapterPort;

public class GetListCategoryProductUseCase implements GetListCategoryProductUseCasePort {
	
	private final GetListCategoryProductAdapterPort getListCategoryProductAdapterPort;

	public GetListCategoryProductUseCase(GetListCategoryProductAdapterPort getListCategoryProductAdapterPort) {
		this.getListCategoryProductAdapterPort = getListCategoryProductAdapterPort;
	}

	@Override
	public CategoryProductResponse listProductsByCategory(Long categoryId) {
		return getListCategoryProductAdapterPort.listProductsByCategory(categoryId);
	}

}
