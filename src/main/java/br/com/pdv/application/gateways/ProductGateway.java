package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Product;

import java.util.List;

public interface ProductGateway {

    List<Product> listProductByCategoryId(Long categoryId);

    Product createProduct(Product product);

    Product updateProduct(Product product, Long productId);

    void deleteProduct(Long productId);

    Product findById(Long id);

}
