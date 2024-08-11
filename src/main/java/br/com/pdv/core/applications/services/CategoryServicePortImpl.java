package br.com.pdv.core.applications.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.mapper.ProductMapper;
import br.com.pdv.adapter.driven.infra.response.CategoryProductResponse;
import br.com.pdv.adapter.driven.infra.response.ProductResponse;
import br.com.pdv.core.applications.ports.repositories.ProductRepository;
import br.com.pdv.core.domains.ports.in.CategoryServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class CategoryServicePortImpl implements CategoryServicePort {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Override
	public CategoryProductResponse listProductsByCategory(Long categoryId) {
		
		List<Product> products = productRepository.findByCategory(categoryId);
		
		List<ProductResponse> productsResponse = new ArrayList<>();
		
		products.forEach( product -> {
			ProductResponse response = productMapper.responseMapper(product);
			productsResponse.add(response);
		});
		
		return makeResponse(categoryId, productsResponse);
		
	}

	private CategoryProductResponse makeResponse(Long categoryId, List<ProductResponse> productsResponse) {
		var categoryProductResponse = new CategoryProductResponse();
		categoryProductResponse.setCategoryId(categoryId);
		categoryProductResponse.setProducts(productsResponse);
		return categoryProductResponse;
	}

}
