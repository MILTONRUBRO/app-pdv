package br.com.pdv.adapter.inbound.controller.mapper;


import br.com.pdv.adapter.inbound.controller.request.OrderRequest;
import br.com.pdv.adapter.outbound.integration.repository.entity.CustomerEntity;
import br.com.pdv.adapter.outbound.integration.repository.entity.OrderEntity;
import br.com.pdv.adapter.outbound.integration.repository.entity.OrderStatus;
import br.com.pdv.domain.Customer;
import br.com.pdv.domain.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order requestMapper(OrderRequest request) {
        var order = new Order();
        
        Customer customer = new Customer();
        customer.setDocument(request.getDocumentNumber());
        order.setCustomer(customer);
        return order;
    }


    public OrderEntity toEntity(Order order) {
        var orderEntity = new OrderEntity();
        
        Customer customer = order.getCustomer();
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        
        orderEntity.setCustomer(customerEntity);
        orderEntity.setStatus(OrderStatus.valueOf(order.getStatus().name()));
        orderEntity.setData(order.getData());
        
        return orderEntity;
    }
}
