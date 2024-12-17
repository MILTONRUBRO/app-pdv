package br.com.pdv.infrastructure.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductRequest(
        @Schema(description = "Name of the product", example = "Hamburguer")
        String name,
        @Schema(description = "Description of the product", example = "Big mac")
        String description,
        @Schema(description = "Price of the product", example = "20")
        BigDecimal price,
        @Schema(description = "Category ID of the product", example = "1")
        Long idCategory
) {
}
