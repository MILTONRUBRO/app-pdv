package br.com.pdv.infrastructure.gateways.repository;

import br.com.pdv.application.gateways.CategoryGateway;
import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.entity.Category;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.gateways.mapper.ProductEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.ProductEntity;
import br.com.pdv.infrastructure.persistence.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;
    private final CategoryGateway categoryGateway;

    public ProductRepositoryGateway(ProductRepository productRepository, ProductEntityMapper productEntityMapper, CategoryGateway categoryGateway) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<Product> listProductByCategoryId(Long categoryId) {
        List<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId);
        log.info("Product list by categoryId {}", productEntities);
        return productEntityMapper.toListDomainObj(productEntities);
    }

    @Override
    public Product createProduct(Product productDomainObj) {
        var category = categoryGateway.findById(productDomainObj.idCategory());
        ProductEntity productEntity = productEntityMapper.toEntity(productDomainObj, null);
        ProductEntity savedEntity = productRepository.save(productEntity);
        log.info("Product created {}", savedEntity);
        return productEntityMapper.toDomainObj(savedEntity);

    }

    @Override
    public Product updateProduct(Product productDomainObj, Long productId) {
        var category = categoryGateway.findById(productDomainObj.idCategory());

        ProductEntity productSaved = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Produto Não Encontrado"));
        ProductEntity productEntity = productEntityMapper.toEntity(productDomainObj, productSaved.getId());
        ProductEntity updatedEntity = productRepository.save(productEntity);
        log.info("Product updated {}", updatedEntity);
        return productEntityMapper.toDomainObj(updatedEntity);
    }
}
