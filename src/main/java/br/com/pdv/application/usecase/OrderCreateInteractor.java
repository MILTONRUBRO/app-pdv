package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.domain.entity.Order;

public class OrderCreateInteractor {

    private final OrderGateway orderGateway;

    public OrderCreateInteractor(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order createOrder(Order order) {
        return orderGateway.createOrder(order);
    }
}
