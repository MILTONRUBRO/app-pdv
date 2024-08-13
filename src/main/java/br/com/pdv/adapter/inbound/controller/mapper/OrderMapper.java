package br.com.pdv.adapter.inbound.controller.mapper;


import br.com.pdv.adapter.inbound.controller.request.OrderRequest;
import br.com.pdv.adapter.outbound.integration.repository.OrderEntity;
import br.com.pdv.domain.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order requestMapper(OrderRequest request) {
        var order = new Order();
        BeanUtils.copyProperties(request, order);
        return order;
    }


    public OrderEntity toEntity(Order order) {
        var orderEntity = new OrderEntity();
        BeanUtils.copyProperties(order, orderEntity);
        return orderEntity;
    }
}
