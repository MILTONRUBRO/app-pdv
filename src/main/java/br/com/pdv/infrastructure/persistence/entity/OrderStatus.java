package br.com.pdv.infrastructure.persistence.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
public enum OrderStatus {

    RECEIVED("recebido"),
    PROCESSING("processando"),
    COMPLETED("completado");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static OrderStatus fromString(String status) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.status.equalsIgnoreCase(status)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + status);
    }
}