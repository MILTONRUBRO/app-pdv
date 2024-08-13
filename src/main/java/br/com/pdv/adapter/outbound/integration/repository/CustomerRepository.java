package br.com.pdv.adapter.outbound.integration.repository;

import java.util.Optional;

import br.com.pdv.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByDocument(String document);

}
