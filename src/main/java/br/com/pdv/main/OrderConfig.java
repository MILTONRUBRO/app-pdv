package br.com.pdv.main;

import br.com.pdv.application.gateways.CategoryGateway;
import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.controllers.mappers.ProductDTOMapper;
import br.com.pdv.infrastructure.gateways.mapper.OrderEntityMapper;
import br.com.pdv.infrastructure.gateways.mapper.ProductEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.OrderRepositoryGateway;
import br.com.pdv.infrastructure.gateways.repository.ProductRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.OrderRepository;
import br.com.pdv.infrastructure.persistence.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    OrderCreateInteractor createOrderUseCase(OrderGateway orderGateway) {
        return new OrderCreateInteractor(orderGateway);
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
