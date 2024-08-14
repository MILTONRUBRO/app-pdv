package br.com.pdv.adapter.outbound.integration.repository.adapter;

import br.com.pdv.adapter.inbound.controller.mapper.OrderMapper;
import br.com.pdv.adapter.outbound.integration.repository.OrderRepository;
import br.com.pdv.adapter.outbound.integration.repository.entity.OrderStatus;
import br.com.pdv.domain.ports.outbound.PatchOrderAdapterPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class PatchOrderAdapter implements PatchOrderAdapterPort {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void updateStatus(Long idOrder, br.com.pdv.domain.OrderStatus status) {
        orderRepository.updateOrderStatus(idOrder, OrderStatus.DELIVERED);
    }
}
