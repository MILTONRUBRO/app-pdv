package br.com.pdv.core.applications.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pdv.adapter.driven.infra.entity.Customer;
import br.com.pdv.core.applications.exceptions.NotFoundException;
import br.com.pdv.core.applications.ports.repositories.CustomerRepositoryPort;
import br.com.pdv.core.domains.ports.in.CustomerServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class CustomerServicePortImpl implements CustomerServicePort {
	
	private final CustomerRepositoryPort customerRepository;

	@Override
	public Customer save(Customer customer) {
		var customerSaved = customerRepository.save(customer);
		log.info("Customer Saved {}", customer);
		return customerSaved;
	}

	@Override
	public Customer find(String documentNumber) {
		Optional<Customer> optionalCustomer = customerRepository.findByDocument(documentNumber);
		
		if(!optionalCustomer.isPresent()) {
			throw new NotFoundException("Cliente não encontrado");
		}
		
		return optionalCustomer.get();
	}

}
