package br.com.pdv.main;


import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.application.usecase.ListProductsByCategoryIdInteractor;
import br.com.pdv.infrastructure.controllers.mappers.ProductDTOMapper;
import br.com.pdv.infrastructure.gateways.mapper.ProductEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.ProductRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    ListProductsByCategoryIdInteractor listProducyByCategoryIdUseCase(ProductGateway productGateway) {
        return new ListProductsByCategoryIdInteractor(productGateway);
    }

    @Bean
    ProductGateway productGateway(ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        return new ProductRepositoryGateway(productRepository, productEntityMapper);
    }

    @Bean
    ProductEntityMapper productEntityMapper() {
        return new ProductEntityMapper();
    }

    @Bean
    ProductDTOMapper productDTOMapper() {
        return new ProductDTOMapper();
    }
}
