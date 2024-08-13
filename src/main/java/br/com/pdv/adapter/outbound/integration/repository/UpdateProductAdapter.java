package br.com.pdv.adapter.outbound.integration.repository;

import org.springframework.stereotype.Component;

import br.com.pdv.adapter.inbound.controller.mapper.ProductMapper;
import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.Category;
import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.outbound.UpdateProductAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class UpdateProductAdapter implements UpdateProductAdapterPort {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final ProductMapper productMapper;
	
	@Override
	public void update(Product product, Long idProduct, Category category) {
		var categorySaved = categoryRepository.findById(category.getId())
				.orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

		var productSaved = productRepository.findById(idProduct)
				.orElseThrow(() -> new NotFoundException("Produto Não Encontrado"));

		ProductEntity newProduct = productMapper.toProductEntity(product);
		newProduct.setCategory(categorySaved);
		newProduct.setId(productSaved.getId());

		productRepository.save(newProduct);
	}

}
