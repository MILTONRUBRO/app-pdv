package br.com.pdv.adapter.driven.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "item_order")
public class ItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product produto;

    private int quantity;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Override
    public String toString() {
        return "ItemOrder{" +
                "id=" + id +
                ", order=" + order.getId() +
                ", produto=" + produto.getId() +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                '}';
    }
}
