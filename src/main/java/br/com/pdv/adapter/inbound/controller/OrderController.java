package br.com.pdv.adapter.inbound.controller;

import br.com.pdv.adapter.driven.infra.dto.request.OrderRequest;
import br.com.pdv.adapter.driven.infra.dto.request.UpdateOrderStatusRequest;
import br.com.pdv.core.domains.ports.in.OrderServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Log4j2
public class OrderController {

	private final OrderServicePort orderServicePort;


	@PostMapping
	public ResponseEntity<Void> createOrder(@RequestBody OrderRequest request) {
		log.info("POST Order Request: {}", request);
		orderServicePort.create(request);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{idOrder}")
	public ResponseEntity<Void> updateOrderStatus(@PathVariable Long idOrder, @RequestBody @Valid UpdateOrderStatusRequest updateOrderStatusRequest) {
		log.info("PATCH update status for Order ID: {}", idOrder);
		orderServicePort.updateOrderStatus(idOrder, updateOrderStatusRequest.getStatus());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
