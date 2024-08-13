package br.com.pdv.adapter.outbound.integration.repository;

import br.com.pdv.adapter.inbound.controller.mapper.OrderMapper;
import br.com.pdv.domain.Order;
import br.com.pdv.domain.ports.outbound.PatchOrderAdapterPort;
import br.com.pdv.domain.ports.outbound.PostOrderAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Log4j2
public class PostOrderAdapter implements PostOrderAdapterPort {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public String save(Order order) {
        OrderEntity orderEntity = orderRepository.save(orderMapper.toEntity(order));
        return order.getId().toString();
    }
}