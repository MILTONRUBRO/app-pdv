package br.com.pdv.infrastructure.gateways.mapper;

import br.com.pdv.domain.entity.Product;
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
}
