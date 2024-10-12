package br.com.pdv.infrastructure.gateways.repository;

import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.gateways.mapper.ProductEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.ProductEntity;
import br.com.pdv.infrastructure.persistence.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryGateway(ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public List<Product> listProductByCategoryId(Long categoryId) {
        List<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId);
        return productEntityMapper.toListDomainObj(productEntities);
    }
}
