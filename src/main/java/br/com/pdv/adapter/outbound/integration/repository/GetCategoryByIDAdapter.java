package br.com.pdv.adapter.outbound.integration.repository;

import org.springframework.stereotype.Component;

import br.com.pdv.adapter.inbound.controller.mapper.CategoryMapper;
import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.Category;
import br.com.pdv.domain.ports.outbound.GetCategoryByIdAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class GetCategoryByIDAdapter implements GetCategoryByIdAdapterPort {
	
	private final CategoryRepository  categoryRepository;
	private final CategoryMapper categoryMapper;

	@Override
	public Category getCategoryById(Long id) {
		var category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
		return categoryMapper.entityToCategory(category);
	}

}
