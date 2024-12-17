package br.com.pdv.domain.entity;

import java.math.BigDecimal;

public record ItemOrder(Long id, Long orderId, Long productId, Integer quantity) {
}