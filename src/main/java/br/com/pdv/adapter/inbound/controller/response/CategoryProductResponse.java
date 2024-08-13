package br.com.pdv.adapter.inbound.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class CategoryProductResponse {
	private Long categoryId;
	List<ProductResponse> products;
}
