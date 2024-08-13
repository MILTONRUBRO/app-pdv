package br.com.pdv.adapter.inbound.controller.response;

import br.com.pdv.adapter.driven.infra.dto.response.ProductResponse;
import lombok.Data;

import java.util.List;

@Data
public class CategoryProductResponse {
	private Long categoryId;
	List<ProductResponse> products;
}
