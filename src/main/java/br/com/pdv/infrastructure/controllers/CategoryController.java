package br.com.pdv.infrastructure.controllers;

import br.com.pdv.application.usecase.ListProductsByCategoryIdInteractor;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.controllers.mappers.ProductDTOMapper;
import br.com.pdv.infrastructure.controllers.response.ProductsByCategoryIdResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ListProductsByCategoryIdInteractor listProductUseCase;
    private final ProductDTOMapper productDTOMapper;

    public CategoryController(ListProductsByCategoryIdInteractor listProductUseCase, ProductDTOMapper productDTOMapper) {
        this.listProductUseCase = listProductUseCase;
        this.productDTOMapper = productDTOMapper;
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<ProductsByCategoryIdResponse> listProductsByCategory(@PathVariable Long categoryId) {
        log.info("List Products by category ID: {}", categoryId);
        List<Product> products = listProductUseCase.listProductsByCategoryId(categoryId);
        ProductsByCategoryIdResponse response = productDTOMapper.toListResponse(products);
        return ResponseEntity.ok(response);
    }
}