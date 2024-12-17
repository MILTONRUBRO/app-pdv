package br.com.pdv.infrastructure.gateways.mapper;

import br.com.pdv.domain.entity.Category;
import br.com.pdv.infrastructure.persistence.entity.CategoryEntity;

public class CategoryEntityMapper {

    public Category toDomainObj(CategoryEntity savedEntity) {
        return new Category(
                savedEntity.getId(),
                savedEntity.getName()
        );
    }
}
