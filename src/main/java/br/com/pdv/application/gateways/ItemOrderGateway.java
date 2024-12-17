package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.ItemOrder;

public interface ItemOrderGateway {

    ItemOrder addItemOrder(ItemOrder itemOrder);
}
