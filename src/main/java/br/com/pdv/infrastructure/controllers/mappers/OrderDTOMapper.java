package br.com.pdv.infrastructure.controllers.mappers;

import br.com.pdv.domain.entity.Customer;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.request.OrderRequest;

public class OrderDTOMapper {

    public Order toProduct(OrderRequest request) {
        Customer customer = new Customer(null, null, null, request.documentNumber());
        return new Order(null, null, null, null, customer, null, null);
    }
}
