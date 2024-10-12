package br.com.pdv.infrastructure.gateways.mapper;

import br.com.pdv.domain.entity.Customer;
import br.com.pdv.infrastructure.persistence.entity.CustomerEntity;

public class CustomerEntityMapper {
	
    public Customer entityToCustomer(CustomerEntity customerEntity) {

        return new Customer(customerEntity.getId(), customerEntity.getName(), 
        		customerEntity.getEmail(), customerEntity.getDocument());
    }

}
