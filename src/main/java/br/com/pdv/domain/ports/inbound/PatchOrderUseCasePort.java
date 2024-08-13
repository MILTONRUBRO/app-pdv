package br.com.pdv.domain.ports.inbound;

import br.com.pdv.domain.OrderStatus;

public interface PatchOrderUseCasePort {

    void execute(Long idProduct, OrderStatus status);

}
