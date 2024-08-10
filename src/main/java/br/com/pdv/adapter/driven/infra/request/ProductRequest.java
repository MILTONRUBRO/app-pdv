package br.com.pdv.adapter.driven.infra.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductRequest {
	
	private String name;
	private String description;
	private BigDecimal price;
	private Long idCategory;

}
