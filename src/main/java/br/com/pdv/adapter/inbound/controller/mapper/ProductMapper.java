package br.com.pdv.adapter.inbound.controller.mapper;


import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.adapter.inbound.controller.response.ProductResponse;
import br.com.pdv.adapter.outbound.integration.repository.entity.ProductEntity;
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

    public ProductResponse responseMapper(ProductEntity productEntity) {
        var productResponse = new ProductResponse();
        BeanUtils.copyProperties(productEntity, productResponse);
        return productResponse;
    }
    
    public ProductEntity toProductEntity(Product product) {
        var productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        return productEntity;
    }
    
    public Product entityToProduct(ProductEntity productEntity) {
        var product = new Product();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

}
