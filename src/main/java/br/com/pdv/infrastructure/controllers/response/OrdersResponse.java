package br.com.pdv.infrastructure.controllers.response;

public record OrdersResponse(Long id, String status, String customer, String dataHora) {
}
