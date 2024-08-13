package br.com.pdv.adapter.inbound.controller.mapper;

import br.com.pdv.adapter.inbound.controller.request.CustomerRequest;
import br.com.pdv.adapter.inbound.controller.response.CustomerResponse;
import br.com.pdv.domain.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper {

    public Customer requestMapper(CustomerRequest request) {
        var customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        return customer;
    }

    public CustomerResponse responseMapper(Customer customer) {
        var customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }

}
