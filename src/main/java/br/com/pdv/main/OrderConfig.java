package br.com.pdv.main;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.gateways.ItemOrderGateway;
import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.application.usecase.UpdateOrderStatusInteractor;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.gateways.mapper.ItemOrderEntityMapper;
import br.com.pdv.infrastructure.gateways.mapper.OrderEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.OrderRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    OrderCreateInteractor createOrderUseCase(OrderGateway orderGateway) {
        return new OrderCreateInteractor(orderGateway);
    }
    
    @Bean
    UpdateOrderStatusInteractor updateOrderStatusInteractor(OrderGateway orderGateway) {
    	return new UpdateOrderStatusInteractor(orderGateway);
    }

    @Bean
    OrderDTOMapper orderDTOMapper() {
        return new OrderDTOMapper();
    }

    @Bean
    OrderGateway orderGateway(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper, CustomerGateway customerGateway ,  ItemOrderGateway itemOrderGateway) {
        return new OrderRepositoryGateway(orderRepository, orderEntityMapper,customerGateway,itemOrderGateway);
    }

    @Bean
    OrderEntityMapper orderEntityMapper() {
        return new OrderEntityMapper();
    }
}
