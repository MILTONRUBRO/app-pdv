package br.com.pdv.infrastructure.controllers.mappers;

import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.controllers.request.ProductRequest;
import br.com.pdv.infrastructure.controllers.response.ProductResponse;
import br.com.pdv.infrastructure.controllers.response.ProductsByCategoryIdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDTOMapper {

    public ProductsByCategoryIdResponse toListResponse(List<Product> products) {
        List<ProductResponse> productResponses = products.stream()
                .map(product -> new ProductResponse(
                        product.name(),
                        product.description(),
                        product.price()
                ))
                .collect(Collectors.toList());
        return new ProductsByCategoryIdResponse(productResponses);
    }

    public Product toProduct(ProductRequest request) {
        return new Product(null, request.name(), request.description(), request.price(), request.idCategory());
    }
}
