package br.com.pdv.infrastructure.controllers;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.application.usecase.CreateCustomerInteractor;
import br.com.pdv.application.usecase.GetCustomerInteractor;
import br.com.pdv.domain.entity.Customer;
import br.com.pdv.infrastructure.controllers.request.CustomerRequest;
import br.com.pdv.infrastructure.gateways.mapper.CustomerEntityMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customers")
@Log4j2
public class CustomerController {
	
	private final GetCustomerInteractor getCustomerInteractor;
	private final CreateCustomerInteractor createCustomerInteractor;
	private final CustomerEntityMapper customerMapper;
	
    public CustomerController(GetCustomerInteractor getCustomerInteractor,
			CreateCustomerInteractor createCustomerInteractor, CustomerEntityMapper customerMapper) {
		this.getCustomerInteractor = getCustomerInteractor;
		this.createCustomerInteractor = createCustomerInteractor;
		this.customerMapper = customerMapper;
	}

	@PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerRequest request) {
        log.info("POST Customer Request: {}", request);
        
        Customer customer = customerMapper.requestToCustomer(request);
        Customer savedCustomer = createCustomerInteractor.createCustomer(customer);
       
        URI location = URI.create("/customers/" + savedCustomer.id());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<Customer> find(@PathVariable String documentNumber) {
        log.info("GET Customer Document: {}", documentNumber);
        Customer customer = getCustomerInteractor.findCustomerByDocument(documentNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

}