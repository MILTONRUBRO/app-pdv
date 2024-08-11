package br.com.pdv.adapter.driver.controller;

import br.com.pdv.adapter.driven.infra.dto.request.ItemOrderRequest;
import br.com.pdv.core.domains.ports.in.ItemOrderServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-items")
@AllArgsConstructor
@Log4j2
public class ItemOrderController {

	private final ItemOrderServicePort itemOrderServicePort;


	@PostMapping
	public ResponseEntity<Void> addItem(@RequestBody ItemOrderRequest request) {
		log.info("POST AddItem Request: {}", request);
		itemOrderServicePort.addItem(request);
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
