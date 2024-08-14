package br.com.pdv.adapter.outbound.integration.repository.adapter;

import org.springframework.stereotype.Component;

import br.com.pdv.adapter.inbound.controller.mapper.ProductMapper;
import br.com.pdv.adapter.inbound.controller.request.ProductRequest;
import br.com.pdv.adapter.outbound.integration.repository.CategoryRepository;
import br.com.pdv.adapter.outbound.integration.repository.ProductRepository;
import br.com.pdv.adapter.outbound.integration.repository.entity.ProductEntity;
import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.outbound.PostProductAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class PostProductAdapter implements PostProductAdapterPort {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final ProductMapper productMapper;
	
	@Override
	public void save(Product product, ProductRequest request) {		
		var category = categoryRepository.findById(request.getIdCategory())
				.orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
		
		ProductEntity productEntity = productMapper.toProductEntity(product);
		productEntity.setCategory(category);
		productRepository.save(productEntity);
		log.info("Product Saved {}", productEntity);
		
	}
	

}
