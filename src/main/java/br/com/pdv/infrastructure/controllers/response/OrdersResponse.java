package br.com.pdv.infrastructure.controllers.response;

import br.com.pdv.domain.entity.Product;

import java.util.List;

public record OrdersResponse(Long id, String status, String cliente, String data, String hora, List<ItemsOrdersResponse> produtosPedido) {
}
