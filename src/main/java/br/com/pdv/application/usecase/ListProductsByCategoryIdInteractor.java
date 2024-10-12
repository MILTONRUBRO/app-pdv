package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.domain.entity.Product;

import java.util.List;

public class ListProductsByCategoryIdInteractor {

    private final ProductGateway productGateway;

    public ListProductsByCategoryIdInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> listProductsByCategoryId(Long categoryId) {
        return productGateway.listProductByCategoryId(categoryId);
    }
}
