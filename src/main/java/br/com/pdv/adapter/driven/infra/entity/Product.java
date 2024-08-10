package br.com.pdv.adapter.driven.infra.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Product {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
}
