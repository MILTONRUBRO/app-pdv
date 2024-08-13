package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Order;
import br.com.pdv.domain.OrderStatus;

public interface PatchOrderAdapterPort {
    void updateStatus(Long idProduct, OrderStatus status);
}
