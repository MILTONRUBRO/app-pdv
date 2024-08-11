package br.com.pdv.adapter.driven.infra.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductResponse {
	private String name;
	private String description;
	private BigDecimal price;
}
