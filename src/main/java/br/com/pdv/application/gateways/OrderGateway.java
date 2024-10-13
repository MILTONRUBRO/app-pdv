package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Order;
import br.com.pdv.domain.entity.Product;

import java.util.List;

public interface OrderGateway {
    Order createOrder(Order order);
}