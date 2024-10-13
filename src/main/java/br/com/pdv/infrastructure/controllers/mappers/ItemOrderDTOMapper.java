package br.com.pdv.infrastructure.controllers.mappers;

import br.com.pdv.domain.entity.ItemOrder;
import br.com.pdv.infrastructure.controllers.request.ItemOrderRequest;

public class ItemOrderDTOMapper {

    public ItemOrder toItemOrder(ItemOrderRequest request) {
        return new ItemOrder(
                request.id(),
                request.orderId(),
                request.productId(),
                request.quantity()
        );
    }
}
