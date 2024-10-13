package br.com.pdv.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.application.usecase.GetCustomerInteractor;
import br.com.pdv.infrastructure.gateways.mapper.CustomerEntityMapper;
import br.com.pdv.infrastructure.gateways.repository.CustomerRepositoryGateway;
import br.com.pdv.infrastructure.persistence.repository.CustomerRepository;

@Configuration
public class CustomerConfig {
	
	@Bean
	public GetCustomerInteractor getCustomerInteractor (CustomerGateway customerGateway) {
		return new GetCustomerInteractor(customerGateway);
	}
	
    @Bean
    CustomerGateway customerGateway(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper ) {
        return new CustomerRepositoryGateway(customerRepository, customerEntityMapper);
    }

	
	@Bean
	CustomerEntityMapper customerEntityMapper() {
		return new CustomerEntityMapper();
	}

}
