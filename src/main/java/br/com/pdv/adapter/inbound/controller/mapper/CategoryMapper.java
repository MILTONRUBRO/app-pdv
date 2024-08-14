package br.com.pdv.adapter.inbound.controller.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.pdv.adapter.outbound.integration.repository.entity.CategoryEntity;
import br.com.pdv.domain.Category;

@Component
public class CategoryMapper {
	
	public Category entityToCategory(CategoryEntity categoryEntity ) {
		var category = new Category();
        BeanUtils.copyProperties(categoryEntity, category);
        return category;
	}

}
