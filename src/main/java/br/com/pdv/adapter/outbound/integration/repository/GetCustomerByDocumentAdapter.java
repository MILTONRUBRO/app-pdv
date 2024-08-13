package br.com.pdv.adapter.outbound.integration.repository;

import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.Customer;
import br.com.pdv.domain.ports.outbound.GetCustomerByDocumentAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetCustomerByDocumentAdapter implements GetCustomerByDocumentAdapterPort {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(String document) {
        Optional<Customer> optionalCustomer = customerRepository.findByDocument(document);
        if (!optionalCustomer.isPresent()) {
            throw new NotFoundException("Cliente não encontrado");
        }
        return optionalCustomer.get();
    }
}
