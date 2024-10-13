package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Order;

public interface OrderGateway {
    Order createOrder(Order order);
    void updateOrderStatus(Long idOrder, String status);
    String getOrderPaymentSatus(Long idOrder);
}