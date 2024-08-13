package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Category;
import br.com.pdv.domain.ports.inbound.GetCategoryByIDUseCasePort;
import br.com.pdv.domain.ports.outbound.GetCategoryByIdAdapterPort;

public class GetCategoryByIdUseCase implements GetCategoryByIDUseCasePort {
	
	private final GetCategoryByIdAdapterPort getCategoryByIdAdapterPort;
	
	public GetCategoryByIdUseCase(GetCategoryByIdAdapterPort getCategoryByIdAdapterPort) {
		this.getCategoryByIdAdapterPort = getCategoryByIdAdapterPort;
	}

	@Override
	public Category execute(Long id) {
		return getCategoryByIdAdapterPort.getCategoryById(id);
	}

}
