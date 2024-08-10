package br.com.pdv.adapter.driver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.adapter.driven.infra.mapper.ProductMapper;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;
import br.com.pdv.core.domains.ports.in.ProductServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Log4j2
public class ProductController {

	private final ProductMapper productMapper;
	private final ProductServicePort productServicePort;

	@PostMapping
	public ResponseEntity<Void> saveProduct(@RequestBody ProductRequest request) {
		log.info("POST Product Request: {}", request);
		var product = productMapper.requestMapper(request);
		productServicePort.save(product, request);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{idProduct}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
		log.info("DELETE Product ID: {}", idProduct);
		productServicePort.delete(idProduct);
		return ResponseEntity.noContent().build();
	}

}
