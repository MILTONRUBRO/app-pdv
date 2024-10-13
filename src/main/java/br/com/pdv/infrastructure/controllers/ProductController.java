package br.com.pdv.infrastructure.controllers;

import br.com.pdv.application.usecase.CreateProductInteractor;
import br.com.pdv.application.usecase.DeleteProductInteractor;
import br.com.pdv.application.usecase.UpdateProductInteractor;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.controllers.mappers.ProductDTOMapper;
import br.com.pdv.infrastructure.controllers.request.ProductRequest;
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

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody ProductRequest request) {
        log.info("POST Product Request: {}", request);
        Product productBusinessObj = productDTOMapper.toProduct(request);
        Product product = createProductUseCase.createProduct(productBusinessObj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idProduct}")
    public void updateProduct(@RequestBody ProductRequest request, @PathVariable Long idProduct) {
        log.info("UPDATE Product {} With ID: {}", request, idProduct);
        Product product = productDTOMapper.toProduct(request);
        updateProductUseCase.updateProduct(product, idProduct);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
        log.info("DELETE Product ID: {}", idProduct);
        deleteProductUseCase.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }


}
