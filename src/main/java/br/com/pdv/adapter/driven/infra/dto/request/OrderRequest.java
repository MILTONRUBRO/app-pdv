package br.com.pdv.adapter.driven.infra.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {

	@NotNull
	@Schema(description = "document number of the client", example = "123")
	private String documentNumber ;
}
