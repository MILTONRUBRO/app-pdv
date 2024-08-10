package br.com.pdv.core.applications.services;

import org.springframework.stereotype.Service;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.mapper.ProductMapper;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;
import br.com.pdv.core.applications.exceptions.NotFoundException;
import br.com.pdv.core.applications.ports.repositories.CategoryRepository;
import br.com.pdv.core.applications.ports.repositories.ProductRepository;
import br.com.pdv.core.domains.ports.in.ProductServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class ProductServicePortImpl implements ProductServicePort {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Override
	public void save(Product product, ProductRequest request) {
		var category = categoryRepository.findById(request.getIdCategory())
				.orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

		product.setCategory(category);
		productRepository.save(product);

		log.info("Product Saved {}", product);
	}

	@Override
	public void delete(Long idProduct) {
		var product = productRepository.findById(idProduct)
				.orElseThrow(() -> new NotFoundException("Produto Não Encontrado"));
		
		productRepository.delete(product);

	}

	@Override
	public void update(ProductRequest request, Long idProduct) {
		var category = categoryRepository.findById(request.getIdCategory())
				.orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
		
		var productSaved = productRepository.findById(idProduct)
				.orElseThrow(() -> new NotFoundException("Produto Não Encontrado"));
		
		Product newProduct = productMapper.requestMapper(request);
		newProduct.setCategory(category);
		newProduct.setId(productSaved.getId());
		
		productRepository.save(newProduct);
	}


}
