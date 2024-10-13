package br.com.pdv.infrastructure.controllers.request;

public record ItemOrderRequest(Long id, Long orderId, Long productId, Integer quantity) {
}


