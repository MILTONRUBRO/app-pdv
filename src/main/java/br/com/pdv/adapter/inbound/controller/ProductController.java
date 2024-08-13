package br.com.pdv.adapter.inbound.controller;

import br.com.pdv.adapter.inbound.controller.mapper.ProductMapper;
import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.inbound.PostProductUseCasePort;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Log4j2
public class ProductController {

	private final ProductMapper productMapper;
	//private final ProductServicePort productServicePort;
	private final PostProductUseCasePort  postProductUseCasePort;

	@PostMapping
	public ResponseEntity<Void> saveProduct(@RequestBody ProductRequest request) {
		log.info("POST Product Request: {}", request);
		var product = productMapper.requestMapper(request);
		postProductUseCasePort.save(product, request);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{idProduct}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
		log.info("DELETE Product ID: {}", idProduct);
		productServicePort.delete(idProduct);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idProduct}")
	public void updateProduct(@RequestBody ProductRequest request, @PathVariable Long idProduct) {
		log.info("UPDATE Product {} With ID: {}",request, idProduct);
		Product product = productMapper.requestMapper(request);
		productServicePort.update(request, idProduct);

	}

}
