package br.com.pdv.infrastructure.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductRequest(
        String name,
        String description,
        BigDecimal price,
        Long idCategory
) {
}
