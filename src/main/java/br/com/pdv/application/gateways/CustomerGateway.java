package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Customer;
import br.com.pdv.infrastructure.persistence.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerGateway {
	
	Customer findByDocument(String document);
	Optional<Customer>findByDocumentForOrder(String document);
	Customer createCustomer(Customer customer);
	Long  nextCustomerId();

}
