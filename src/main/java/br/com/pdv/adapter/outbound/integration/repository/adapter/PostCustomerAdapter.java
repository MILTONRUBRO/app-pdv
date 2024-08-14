package br.com.pdv.adapter.outbound.integration.repository.adapter;

import br.com.pdv.adapter.inbound.controller.mapper.CustomerMapper;
import br.com.pdv.adapter.outbound.integration.repository.CustomerRepository;
import br.com.pdv.adapter.outbound.integration.repository.entity.CustomerEntity;
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
    private final CustomerMapper customerMapper;

    @Override
    public String saveCustomer(Customer customer) {
    	CustomerEntity customerEntity = customerMapper.toCustomerEntity(customer);
    	
        var customerSaved = customerRepository.save(customerEntity);
        log.info("Customer Saved {}", customer);
        return customerSaved.getDocument();
    }
}
