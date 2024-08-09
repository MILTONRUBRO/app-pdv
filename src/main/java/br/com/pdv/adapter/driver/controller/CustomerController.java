package br.com.pdv.adapter.driver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.adapter.driven.infra.entity.Customer;
import br.com.pdv.adapter.driven.infra.mapper.CustomerMapper;
import br.com.pdv.adapter.driven.infra.request.CustomerRequest;
import br.com.pdv.adapter.driven.infra.response.CustomerResponse;
import br.com.pdv.core.domains.ports.in.CustomerServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@Log4j2
public class CustomerController {

	private final CustomerMapper customerMapper;
	private final CustomerServicePort customerServicePort;

	@PostMapping
	public Customer salvarUsuario(@RequestBody CustomerRequest request) {
		log.info("POST Customer Request: {}", request);
		var customer = customerMapper.requestMapper(request);
		return customerServicePort.save(customer);
	}

	@GetMapping("/{documentNumber}")
	public ResponseEntity<CustomerResponse> find(@PathVariable String documentNumber) {
		log.info("GET Customer Document: {}", documentNumber);

		Customer customerSaved = customerServicePort.find(documentNumber);
		CustomerResponse customerResponse = customerMapper.responseMapper(customerSaved);

		return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
	}

}
