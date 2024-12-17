package br.com.pdv.main;

import br.com.pdv.application.gateways.CategoryGateway;
import br.com.pdv.infrastructure.gateways.mapper.CategoryEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.CategoryRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    CategoryGateway categoryGateway(CategoryRepository categoryRepository, CategoryEntityMapper categoryEntityMapper) {
        return new CategoryRepositoryGateway(categoryRepository, categoryEntityMapper);
    }

    @Bean
    CategoryEntityMapper categoryEntityMapper() {
        return new CategoryEntityMapper();
    }

}
