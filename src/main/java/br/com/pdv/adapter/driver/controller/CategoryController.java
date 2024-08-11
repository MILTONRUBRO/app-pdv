package br.com.pdv.adapter.driver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.adapter.driven.infra.response.CategoryProductResponse;
import br.com.pdv.core.domains.ports.in.CategoryServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
@Log4j2
public class CategoryController {

	private final CategoryServicePort categoryServicePort;

	@GetMapping("/{categoryId}/products")
	public ResponseEntity<CategoryProductResponse> listProductsByCategory(@PathVariable Long categoryId) {
		log.info("List Products by category ID: {}", categoryId);
		CategoryProductResponse response = categoryServicePort.listProductsByCategory(categoryId);
		return ResponseEntity.ok(response);
	}

}
