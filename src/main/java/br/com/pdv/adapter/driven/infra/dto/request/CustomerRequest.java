package br.com.pdv.adapter.driven.infra.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerRequest {

    @Schema(description = "Name of the customer", example = "Joao pedro")
    private String name;
    @Schema(description = "Email of the customer", example = "joao_pedro@gmail.com")
    private String email;
    @Schema(description = "Document of the customer", example = "123")
    private String document;
}
