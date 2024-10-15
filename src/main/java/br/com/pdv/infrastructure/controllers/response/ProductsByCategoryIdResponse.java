package br.com.pdv.infrastructure.controllers.response;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ProductsByCategoryIdResponse(
        @Schema(description = "List of products in the category")
        List<ProductResponse> products) {
}

