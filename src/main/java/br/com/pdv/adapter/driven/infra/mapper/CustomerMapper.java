package br.com.pdv.adapter.driven.infra.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.pdv.adapter.driven.infra.entity.Customer;
import br.com.pdv.adapter.driven.infra.dto.request.CustomerRequest;
import br.com.pdv.adapter.driven.infra.dto.response.CustomerResponse;

@Component
public class CustomerMapper {
	
    public Customer requestMapper(CustomerRequest request){
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
