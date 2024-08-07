package br.com.pdv.adapter.driven.infra.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.pdv.adapter.driven.infra.entity.Customer;
import br.com.pdv.adapter.driven.infra.request.CustomerRequest;

@Component
public class CustomerRequestToCustomerMapper {
	
    public Customer mapper(CustomerRequest request){
        var customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        return customer;
    }

}
