package br.com.pdv.adapter.inbound.controller.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
	private String name;
	private String description;
	private BigDecimal price;
}
