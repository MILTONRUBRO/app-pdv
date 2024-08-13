package br.com.pdv.adapter.inbound.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

	@Schema(description = "Name of the product", example = "Big mac")
	private String name;
	@Schema(description = "Description of the product", example = "Lanche delicioso")
	private String description;
	@Schema(description = "Price of the product", example ="20.00")
	private BigDecimal price;
	@Schema(description = "Category id of the product", example ="1")
	private Long idCategory;
}
