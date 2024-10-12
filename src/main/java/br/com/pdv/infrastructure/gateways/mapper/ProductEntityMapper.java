package br.com.pdv.infrastructure.gateways.mapper;

import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.persistence.entity.CategoryEntity;
import br.com.pdv.infrastructure.persistence.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductEntityMapper {


    public List<Product> toListDomainObj(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(entity -> new Product(
                        entity.getId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getPrice(),
                        entity.getCategory().getId()
                ))
                .collect(Collectors.toList());
    }

    public ProductEntity toEntity(Product productDomainObj, Long productId) {
        CategoryEntity categoryEntity = new CategoryEntity(productDomainObj.idCategory(), null);
        return new ProductEntity(
                productId,
                productDomainObj.name(),
                productDomainObj.description(),
                productDomainObj.price(),
                categoryEntity
        );
    }

    public Product toDomainObj(ProductEntity savedEntity) {
        return new Product(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getDescription(),
                savedEntity.getPrice(),
                savedEntity.getCategory().getId()
        );
    }
}
