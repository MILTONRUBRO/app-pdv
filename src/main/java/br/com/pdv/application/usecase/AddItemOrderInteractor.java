package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.ItemOrderGateway;
import br.com.pdv.domain.entity.ItemOrder;

public class AddItemOrderInteractor {

    private final ItemOrderGateway orderGateway;

    public AddItemOrderInteractor(ItemOrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public ItemOrder addItemOrder(ItemOrder itemOrder) {
        return orderGateway.addItemOrder(itemOrder);
    }
}
