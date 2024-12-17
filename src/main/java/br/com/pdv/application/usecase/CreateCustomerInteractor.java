package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.CustomerGateway;
import br.com.pdv.domain.entity.Customer;

public class CreateCustomerInteractor {
	
	private final CustomerGateway customerGateway;

	public CreateCustomerInteractor(CustomerGateway customerGateway) {
		this.customerGateway = customerGateway;
	}
	
	public Customer createCustomer(Customer customer) {
		return customerGateway.createCustomer(customer);
	}

}
