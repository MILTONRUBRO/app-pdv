package br.com.pdv.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.application.usecase.UpdateOrderStatusInteractor;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.gateways.mapper.OrderEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.OrderRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.OrderRepository;

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
    OrderGateway orderGateway(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper, CustomerGateway customerGateway) {
        return new OrderRepositoryGateway(orderRepository, orderEntityMapper,customerGateway);
    }

    @Bean
    OrderEntityMapper orderEntityMapper() {
        return new OrderEntityMapper();
    }
}
