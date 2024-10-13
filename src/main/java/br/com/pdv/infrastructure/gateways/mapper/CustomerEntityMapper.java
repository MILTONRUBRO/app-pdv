package br.com.pdv.infrastructure.gateways.mapper;

import br.com.pdv.domain.entity.Customer;
import br.com.pdv.infrastructure.controllers.request.CustomerRequest;
import br.com.pdv.infrastructure.persistence.entity.CustomerEntity;

public class CustomerEntityMapper {
	
    public Customer entityToCustomer(CustomerEntity customerEntity) {

        return new Customer(customerEntity.getId(), customerEntity.getName(), 
        		customerEntity.getEmail(), customerEntity.getDocument());
    }
    
    public CustomerEntity customerToEntity(Customer customer) {
    	var customerEntity = new CustomerEntity();
		customerEntity.setId(customer.id());
    	customerEntity.setDocument(customer.document());
    	customerEntity.setEmail(customer.email());
    	customerEntity.setName(customer.name());
    	
    	return customerEntity;
    }

	public Customer requestToCustomer(CustomerRequest request) {
		return new Customer(null, request.name(), request.email(), request.document());
	}

}
