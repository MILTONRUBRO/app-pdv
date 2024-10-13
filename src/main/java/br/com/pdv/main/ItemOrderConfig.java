package br.com.pdv.main;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.gateways.ItemOrderGateway;
import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.application.usecase.AddItemOrderInteractor;
import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.infrastructure.controllers.mappers.ItemOrderDTOMapper;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.gateways.mapper.ItemOrderEntityMapper;
import br.com.pdv.infrastructure.gateways.mapper.OrderEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.ItemOrderRepositoryGateway;
import br.com.pdv.infrastructure.gateways.repository.OrderRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.ItemOrderRepository;
import br.com.pdv.infrastructure.persistence.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemOrderConfig {

    @Bean
    AddItemOrderInteractor addItemOrderUseCase(ItemOrderGateway itemOrderGateway) {
        return new AddItemOrderInteractor(itemOrderGateway);
    }

    @Bean
    ItemOrderDTOMapper itemOrderDTOMapper() {
        return new ItemOrderDTOMapper();
    }

    @Bean
    ItemOrderGateway itemOrderGateway(ItemOrderRepository itemOrderRepository, ItemOrderEntityMapper itemOrderEntityMapper, ProductGateway productGateway) {
        return new ItemOrderRepositoryGateway(itemOrderRepository, itemOrderEntityMapper, productGateway);
    }

    @Bean
    ItemOrderEntityMapper itemOrderEntityMapper() {
        return new ItemOrderEntityMapper();
    }
}