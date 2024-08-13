package br.com.pdv.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum PaymentMethod {
    PIX("PIX"),
    QR_CODE("QR Code"),
    CASH("Dinheiro"),
    CREDIT_CARD("Cartão de Crédito");


    private final String paymentType;

    PaymentMethod(String displayName) {
        this.paymentType = displayName;
    }
}