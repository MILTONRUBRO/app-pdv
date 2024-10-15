package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.response.OrdersResponse;

import java.util.List;

public interface OrderGateway {
    Order createOrder(Order order);
    void updateOrderStatus(Long idOrder, String status);
    void updateOrderPayments(Long idOrder, String status);
    String getOrderPaymentSatus(Long idOrder);
    List<OrdersResponse> getAllOrdersOrdenedInteractor();
}