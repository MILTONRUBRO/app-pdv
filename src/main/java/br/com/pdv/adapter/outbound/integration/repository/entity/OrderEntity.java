package br.com.pdv.adapter.outbound.integration.repository.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    private Double totalValue;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PaymentEntity> payments;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemOrderEntity> itens;

    @Override
    public String toString() {

        return "Order{" +
                "id=" + id +
                ", data=" + data +
                ", status=" + status +
                ", totalValue=" + totalValue +
                ", customer=" + customer.getId() +
                ", payments=" + payments +
                ", itens=" + itens +
                '}';
    }
}
