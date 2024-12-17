package br.com.pdv.infrastructure.controllers;

import br.com.pdv.application.usecase.CreateProductInteractor;
import br.com.pdv.application.usecase.DeleteProductInteractor;
import br.com.pdv.application.usecase.UpdateProductInteractor;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.controllers.mappers.ProductDTOMapper;
import br.com.pdv.infrastructure.controllers.request.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductDTOMapper productDTOMapper;
    private final CreateProductInteractor createProductUseCase;
    private final UpdateProductInteractor updateProductUseCase;
    private final DeleteProductInteractor deleteProductUseCase;


    public ProductController(CreateProductInteractor createProductUseCase, ProductDTOMapper productDTOMapper, UpdateProductInteractor updateProductInteractor, DeleteProductInteractor deleteProductInteractor) {
        this.productDTOMapper = productDTOMapper;
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductInteractor;
        this.deleteProductUseCase = deleteProductInteractor;
    }

    @Operation(summary = "Create a new product",
            description = "Creates a new product with name, description, price, and category ID",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Product created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            })
    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody ProductRequest request) {
        log.info("POST Product Request: {}", request);
        Product productBusinessObj = productDTOMapper.toProduct(request);
        Product product = createProductUseCase.createProduct(productBusinessObj);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Update an existing product",
            description = "Updates an existing product with the provided product details and product ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product updated successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            })
    @PutMapping("/{idProduct}")
    public void updateProduct(@RequestBody ProductRequest request, @PathVariable Long idProduct) {
        log.info("UPDATE Product {} With ID: {}", request, idProduct);
        Product product = productDTOMapper.toProduct(request);
        updateProductUseCase.updateProduct(product, idProduct);
    }

    @Operation(summary = "Delete a product by ID",
            description = "Deletes a product by its ID. If the product does not exist, a 404 response is returned.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            })
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
        log.info("DELETE Product ID: {}", idProduct);
        deleteProductUseCase.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }


}
