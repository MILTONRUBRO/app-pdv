package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.domain.entity.Product;

import java.util.List;

public class CreateProductInteractor {

    private final ProductGateway productGateway;

    public CreateProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product createProduct(Product product) {
        return productGateway.createProduct(product);
    }
}
