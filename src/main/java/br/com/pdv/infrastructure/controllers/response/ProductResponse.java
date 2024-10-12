package br.com.pdv.infrastructure.controllers.response;

import java.math.BigDecimal;

public record ProductResponse(String name,
                              String description,
                              BigDecimal price) {
}
