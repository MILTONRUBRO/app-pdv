package br.com.pdv.domain.entity;

public record Payment(Long id, Double amount, String paymentMethod) {
}