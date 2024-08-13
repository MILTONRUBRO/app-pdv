package br.com.pdv.adapter.inbound.controller.request;

import br.com.pdv.adapter.inbound.controller.response.OrderStatusDeserializer;
import br.com.pdv.adapter.driven.infra.entity.OrderStatus;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderStatusRequest {

    @NotNull
    @JsonDeserialize(using = OrderStatusDeserializer.class)
    @Schema(description = "Status of the order", example = "DELIVERED")
    private OrderStatus status;
}