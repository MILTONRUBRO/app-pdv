package br.com.pdv.adapter.outbound.integration.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
}
