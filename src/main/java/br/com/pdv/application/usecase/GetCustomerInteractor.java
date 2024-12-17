package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.domain.entity.Customer;

public class GetCustomerInteractor {
	
	private final CustomerGateway customerGateway;

	public GetCustomerInteractor(CustomerGateway customerGateway) {
		this.customerGateway = customerGateway;
	}
	
	
	public Customer findCustomerByDocument(String document) {
		return customerGateway.findByDocument(document);
	}

}
