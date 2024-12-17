package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.domain.entity.Product;

public class DeleteProductInteractor {

    private final ProductGateway productGateway;

    public DeleteProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void deleteProduct(Long productId) {
        productGateway.deleteProduct(productId);
    }
}
