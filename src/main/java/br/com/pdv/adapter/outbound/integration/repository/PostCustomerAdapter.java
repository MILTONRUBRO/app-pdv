package br.com.pdv.adapter.outbound.integration.repository;

import br.com.pdv.domain.Customer;
import br.com.pdv.domain.ports.outbound.PostCustomerAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class PostCustomerAdapter implements PostCustomerAdapterPort {

    private final CustomerRepository customerRepository;

    @Override
    public String saveCustomer(Customer customer) {
        var customerSaved = customerRepository.save(customer);
        log.info("Customer Saved {}", customer);
        return customerSaved.getDocument();
    }
}
