package br.com.pdv.infrastructure.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateOrderStatusRequest(@Schema(description = "Status of the order", example = "DELIVERED") String status) {

}
