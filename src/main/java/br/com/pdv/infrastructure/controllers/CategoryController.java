package br.com.pdv.infrastructure.controllers;

import br.com.pdv.application.usecase.ListProductsByCategoryIdInteractor;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.controllers.mappers.ProductDTOMapper;
import br.com.pdv.infrastructure.controllers.response.ProductsByCategoryIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "List products by category ID",
            description = "Retrieves a list of products that belong to the given category ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of products retrieved successfully",
                            content = @Content(schema = @Schema(implementation = ProductsByCategoryIdResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found")
            })
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<ProductsByCategoryIdResponse> listProductsByCategory(@PathVariable Long categoryId) {
        log.info("List Products by category ID: {}", categoryId);
        List<Product> products = listProductUseCase.listProductsByCategoryId(categoryId);
        ProductsByCategoryIdResponse response = productDTOMapper.toListResponse(products);
        return ResponseEntity.ok(response);
    }
}