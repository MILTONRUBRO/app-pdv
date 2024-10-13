package br.com.pdv.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus = PaymentStatus.REFUSED;

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