package br.com.pdv.infrastructure.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record OrderWithItemsRequest(
        @Schema(description = "Document number associated with the order",
                example = "123",
                required = false)
        String documentNumber,

        @Schema(description = "List of items in the order",
                required = true)
        List<ItemOrderRequest> itemsOrder
) {
}