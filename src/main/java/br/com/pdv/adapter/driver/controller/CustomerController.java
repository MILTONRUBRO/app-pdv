package br.com.pdv.adapter.driver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.adapter.driven.infra.entity.Customer;
import br.com.pdv.adapter.driven.infra.mapper.CustomerRequestToCustomerMapper;
import br.com.pdv.adapter.driven.infra.request.CustomerRequest;
import br.com.pdv.core.domains.ports.in.CustomerServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@Log4j2
public class CustomerController {
	
	private final CustomerRequestToCustomerMapper customerRequestToCustomerMapper;
	private final CustomerServicePort customerServicePort;
	
    @PostMapping
    public Customer salvarUsuario(@RequestBody CustomerRequest request){
    	log.info("POST Customer Request: {}", request);
        var customer = customerRequestToCustomerMapper.mapper(request);
        return customerServicePort.save(customer);
    }

}
