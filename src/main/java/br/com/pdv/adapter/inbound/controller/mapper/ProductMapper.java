package br.com.pdv.adapter.inbound.controller.mapper;


import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.adapter.inbound.controller.response.ProductResponse;
import br.com.pdv.domain.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product requestMapper(ProductRequest request) {
        var product = new Product();
        BeanUtils.copyProperties(request, product);
        return product;
    }

    public ProductResponse responseMapper(Product product) {
        var productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }


}
