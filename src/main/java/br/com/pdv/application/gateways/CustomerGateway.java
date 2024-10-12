package br.com.pdv.application.gateways;

import java.util.Optional;

import br.com.pdv.domain.entity.Customer;

public interface CustomerGateway {
	
	Optional<Customer> findByDocument(String document);

}
