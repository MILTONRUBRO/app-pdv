package br.com.pdv.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record Order(Long id,
                    LocalDateTime data,
                    OrderStatus status,
                    Double totalValue,
                    Customer customer,
                    Set<Payment> payments,
                    List<ItemOrder> itemsOrder) {
    public Order withCustomer(Customer newCustomer) {
        return new Order(
                this.id,
                this.data,
                this.status,
                this.totalValue,
                newCustomer,
                this.payments,
                this.itemsOrder
        );
    }
}