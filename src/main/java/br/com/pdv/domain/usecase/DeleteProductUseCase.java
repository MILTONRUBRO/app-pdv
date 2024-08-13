package br.com.pdv.domain.usecase;

import br.com.pdv.domain.ports.inbound.DeleteProductUseCasePort;
import br.com.pdv.domain.ports.outbound.DeleteProductAdapterPort;

public class DeleteProductUseCase implements DeleteProductUseCasePort {
    private final DeleteProductAdapterPort deleteProductAdapterPort;


    public DeleteProductUseCase(DeleteProductAdapterPort deleteProductAdapterPort) {
        this.deleteProductAdapterPort = deleteProductAdapterPort;
    }


    @Override
    public void execute(Long id) {
        deleteProductAdapterPort.delete(id);
    }
}
