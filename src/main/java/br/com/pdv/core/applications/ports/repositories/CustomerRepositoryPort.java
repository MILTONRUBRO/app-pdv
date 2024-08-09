package br.com.pdv.core.applications.ports.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pdv.adapter.driven.infra.entity.Customer;

@Repository
public interface CustomerRepositoryPort extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findByDocument(String document);

}
