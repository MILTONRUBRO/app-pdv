package br.com.pdv.domain.usecase;

import br.com.pdv.domain.ItemOrder;
import br.com.pdv.domain.ports.inbound.PostItemOrderUseCasePort;
import br.com.pdv.domain.ports.outbound.PostItemOrderAdapterPort;

public class PostItemOrderUseCase implements PostItemOrderUseCasePort {

    private final PostItemOrderAdapterPort postOrderItemAdapterPort;

    public PostItemOrderUseCase(PostItemOrderAdapterPort postCustomerServiceAdapterPort) {
        this.postOrderItemAdapterPort = postCustomerServiceAdapterPort;
    }

    @Override
    public void execute(ItemOrder itemOrder) {
        postOrderItemAdapterPort.addItem(itemOrder);
    }
}
