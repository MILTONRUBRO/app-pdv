package br.com.pdv.adapter.outbound.integration.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@Table(name = "customer")
public class CustomerEntity {
	
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private String name;
    private String email;

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderEntity> orders;

}
