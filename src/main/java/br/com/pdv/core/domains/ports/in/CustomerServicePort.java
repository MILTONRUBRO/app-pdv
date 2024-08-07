package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.entity.Customer;

public interface CustomerServicePort {
	
	Customer save(Customer customer);
}
