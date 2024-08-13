package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.inbound.GetProductFindbyIdUseCasePort;
import br.com.pdv.domain.ports.outbound.GetProductFindbyIdAdapterPort;

public class GetProductFindByIdUseCase implements GetProductFindbyIdUseCasePort {

    private final GetProductFindbyIdAdapterPort getProductFindbyIdAdapterPort;

    public GetProductFindByIdUseCase(GetProductFindbyIdAdapterPort getProductFindbyIdAdapterPort) {
        this.getProductFindbyIdAdapterPort = getProductFindbyIdAdapterPort;
    }

	@Override
	public Product execute(Long id) {
		return getProductFindbyIdAdapterPort.getProductById(id);
	}
}

