package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.infrastructure.controllers.response.OrdersResponse;

import java.util.List;

public class GetAllOrdersOrdenedInteractor {

    private final OrderGateway orderGateway;

    public GetAllOrdersOrdenedInteractor(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public List<OrdersResponse> getAllOrdersOrdened() {
      return  orderGateway.getAllOrdersOrdenedInteractor();
    }
}
