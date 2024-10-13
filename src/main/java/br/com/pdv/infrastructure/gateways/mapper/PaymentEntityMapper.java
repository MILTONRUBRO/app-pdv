package br.com.pdv.infrastructure.gateways.mapper;

import br.com.pdv.domain.entity.Payment;
import br.com.pdv.infrastructure.persistence.entity.PaymentEntity;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PaymentEntityMapper {

    // Mapeia PaymentEntity para Payment
    public Payment toDomainObj(PaymentEntity paymentEntity) {
        return new Payment(
                paymentEntity.getId(),
                paymentEntity.getAmount(),
                paymentEntity.getPaymentMethod().getPaymentType() // Converte PaymentMethod
        );
    }

    // Mapeia um Set<PaymentEntity> para Set<Payment>
    public Set<Payment> toDomainObjSet(Set<PaymentEntity> paymentEntities) {
        if (Objects.nonNull(paymentEntities)) {
            return paymentEntities.stream()
                    .map(this::toDomainObj) // Usa o método de mapeamento individual
                    .collect(Collectors.toSet());
        } else {
            return null;
        }

    }

    // Mapeia Payment para PaymentEntity (opcional)
    public PaymentEntity toEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(payment.id());
        paymentEntity.setAmount(payment.amount());
        // Setar outros campos conforme necessário
        return paymentEntity;
    }
}