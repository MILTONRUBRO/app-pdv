package br.com.pdv.adapter.driver.controller;

import br.com.pdv.adapter.driven.infra.mapper.OrderMapper;
import br.com.pdv.adapter.driven.infra.mapper.ProductMapper;
import br.com.pdv.adapter.driven.infra.request.OrderRequest;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;
import br.com.pdv.core.domains.ports.in.OrderServicePort;
import br.com.pdv.core.domains.ports.in.ProductServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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

//	@DeleteMapping("/{idProduct}")
//	public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
//		log.info("DELETE Product ID: {}", idProduct);
//		productServicePort.delete(idProduct);
//		return ResponseEntity.noContent().build();
//	}
//
//	@PutMapping("/{idProduct}")
//	public void updateProduct(@RequestBody ProductRequest request, @PathVariable Long idProduct) {
//		log.info("UPDATE Product {} With ID: {}",request, idProduct);
//		productServicePort.update(request, idProduct);
//
//	}

}
