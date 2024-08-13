package br.com.pdv.domain.ports.inbound;


import br.com.pdv.domain.Customer;

public interface PostCustomerUseCasePort {
	String execute(Customer customer);

}
