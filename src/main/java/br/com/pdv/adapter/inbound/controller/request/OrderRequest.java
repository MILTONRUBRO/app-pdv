package br.com.pdv.adapter.inbound.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {

	@NotNull
	@Schema(description = "document number of the client", example = "123")
	private String documentNumber ;
}
