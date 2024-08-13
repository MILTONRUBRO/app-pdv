package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Order;
import br.com.pdv.domain.OrderStatus;
import br.com.pdv.domain.ports.inbound.PatchOrderUseCasePort;
import br.com.pdv.domain.ports.inbound.PostOrderUseCasePort;
import br.com.pdv.domain.ports.outbound.PatchOrderAdapterPort;
import br.com.pdv.domain.ports.outbound.PostOrderAdapterPort;

public class PatchOrderUseCase implements PatchOrderUseCasePort {

    private final PatchOrderAdapterPort patchOrderAdapterPort;

    public PatchOrderUseCase(PatchOrderAdapterPort patchOrderAdapterPort) {
        this.patchOrderAdapterPort = patchOrderAdapterPort;
    }

    @Override
    public void execute(Long idProduct, OrderStatus status) {
        patchOrderAdapterPort.updateStatus(idProduct, status);

    }
}
