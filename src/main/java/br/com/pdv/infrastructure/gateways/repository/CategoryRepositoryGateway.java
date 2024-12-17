package br.com.pdv.infrastructure.gateways.repository;

import br.com.pdv.application.gateways.CategoryGateway;
import br.com.pdv.application.exception.NotFoundException;
import br.com.pdv.domain.entity.Category;
import br.com.pdv.infrastructure.gateways.mapper.CategoryEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.CategoryEntity;
import br.com.pdv.infrastructure.persistence.repository.CategoryRepository;

public class CategoryRepositoryGateway implements CategoryGateway {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;


    public CategoryRepositoryGateway(CategoryRepository categoryRepository, CategoryEntityMapper categoryEntityMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Category findById(Long categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        return categoryEntityMapper.toDomainObj(category);
    }
}
