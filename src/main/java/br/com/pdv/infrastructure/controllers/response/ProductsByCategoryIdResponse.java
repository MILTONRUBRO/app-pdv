package br.com.pdv.infrastructure.controllers.response;

import java.util.List;

public record ProductsByCategoryIdResponse(
                                           List<ProductResponse> products) {
}

