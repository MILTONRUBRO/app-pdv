package br.com.pdv.infrastructure.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;
public record ItemOrderRequest(
        @Schema(description = "ID of the item (not required in request)",
                example = "1",
                required = false,
                hidden = true)
        Long id,

        @Schema(description = "ID of the order (not required in request)",
                example = "100",
                required = false,
                hidden = true)
        Long orderId,

        @Schema(description = "ID of the product",
                example = "1",
                required = true)
        Long productId,

        @Schema(description = "Quantity of the product in the order",
                example = "2",
                required = true)
        Integer quantity
) {
}