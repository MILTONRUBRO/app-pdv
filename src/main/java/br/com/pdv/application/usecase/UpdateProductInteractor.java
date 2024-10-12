package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.domain.entity.Product;

public class UpdateProductInteractor {

    private final ProductGateway productGateway;

    public UpdateProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product updateProduct(Product product,Long productId) {
        return productGateway.updateProduct(product,productId);
    }
}
