package br.com.pdv.adapter.driven.infra.response;

import java.util.List;

import lombok.Data;

@Data
public class CategoryProductResponse {
	private Long categoryId;
	List<ProductResponse> products;
}
