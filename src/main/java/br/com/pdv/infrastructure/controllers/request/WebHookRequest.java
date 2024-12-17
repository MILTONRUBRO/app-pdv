package br.com.pdv.infrastructure.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record WebHookRequest(
        @Schema(description = "Status of the order",
                example = "Recebido",
                required = true)
        String status,

        @Schema(description = "ID of the order",
                example = "1",
                required = true)
        Long idOrder
) {
}