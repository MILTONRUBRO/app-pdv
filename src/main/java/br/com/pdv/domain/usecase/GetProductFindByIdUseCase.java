package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.outbound.GetProductFindbyIdAdapterPort;

public class GetProductFindByIdUseCase implements GetProductFindbyIdAdapterPort {

    private final GetProductFindbyIdAdapterPort getProductFindbyIdAdapterPort;

    public GetProductFindByIdUseCase(GetProductFindbyIdAdapterPort getProductFindbyIdAdapterPort) {
        this.getProductFindbyIdAdapterPort = getProductFindbyIdAdapterPort;
    }

    @Override
    public Product getProductById(Long id) {
        return getProductFindbyIdAdapterPort.getProductById(id);
    }
}
