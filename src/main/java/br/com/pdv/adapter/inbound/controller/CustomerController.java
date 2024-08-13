package br.com.pdv.adapter.inbound.controller;

import br.com.pdv.adapter.inbound.controller.mapper.CustomerMapper;
import br.com.pdv.adapter.inbound.controller.request.CustomerRequest;
import br.com.pdv.adapter.inbound.controller.response.CustomerResponse;
import br.com.pdv.domain.Customer;
import br.com.pdv.domain.ports.inbound.PostCustomerUseCasePort;
import br.com.pdv.domain.ports.inbound.GetCustomerByDocumentUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.net.URI;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@Log4j2
public class CustomerController {

    private final CustomerMapper customerMapper;
    private final GetCustomerByDocumentUseCasePort getCustomerByDocumentUseCasePort;
    private final PostCustomerUseCasePort postCustomerServicePort;

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerRequest request) {
        log.info("POST Customer Request: {}", request);
        var customer = customerMapper.requestMapper(request);
        String customerID = postCustomerServicePort.execute(customer);
        URI location = URI.create("/customers/" + customerID);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<CustomerResponse> find(@PathVariable String documentNumber) {
        log.info("GET Customer Document: {}", documentNumber);
        Customer customerSaved = getCustomerByDocumentUseCasePort.execute(documentNumber);
        CustomerResponse customerResponse = customerMapper.responseMapper(customerSaved);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }

}
