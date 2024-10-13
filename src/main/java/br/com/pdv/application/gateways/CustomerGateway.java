package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Customer;

public interface CustomerGateway {
	
	Customer findByDocument(String document);

}
