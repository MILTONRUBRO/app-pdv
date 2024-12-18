package br.com.pdv.infrastructure.gateways.repository;

import java.util.Optional;

import br.com.pdv.application.exception.NotFoundException;
import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.domain.entity.Customer;
import br.com.pdv.infrastructure.gateways.mapper.CustomerEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.CustomerEntity;
import br.com.pdv.infrastructure.persistence.repository.CustomerRepository;

public class CustomerRepositoryGateway implements CustomerGateway {
	
	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;
	
	public CustomerRepositoryGateway(CustomerRepository customerRepository,
			CustomerEntityMapper customerEntityMapper) {
		this.customerRepository = customerRepository;
		this.customerEntityMapper = customerEntityMapper;
	}
	
	@Override
	public Customer findByDocument(String document) {
		Optional<CustomerEntity> optionalCustomer = customerRepository.findByDocument(document);
		
        if (!optionalCustomer.isPresent()) {
            throw new NotFoundException("Cliente não encontrado");
        }
        
        return customerEntityMapper.entityToCustomer(optionalCustomer.get());
	}

	@Override
	public Optional<Customer> findByDocumentForOrder(String document) {
		Optional<CustomerEntity> customerEntityOptional = customerRepository.findByDocument(document);
		return customerEntityMapper.toDomainOptional(customerEntityOptional);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		CustomerEntity customerEntity = customerEntityMapper.customerToEntity(customer);
		CustomerEntity customerSaved = customerRepository.saveAndFlush(customerEntity);
		return customerEntityMapper.entityToCustomer(customerSaved);
	}

	@Override
	public Long nextCustomerId() {
		Long maxId = customerRepository.findMaxId();
		return (maxId == null) ? 1 : maxId + 1;
	}
}
