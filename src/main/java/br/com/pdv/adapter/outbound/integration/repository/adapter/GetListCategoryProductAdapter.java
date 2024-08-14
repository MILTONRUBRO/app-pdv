package br.com.pdv.adapter.outbound.integration.repository.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pdv.adapter.inbound.controller.mapper.ProductMapper;
import br.com.pdv.adapter.inbound.controller.response.CategoryProductResponse;
import br.com.pdv.adapter.inbound.controller.response.ProductResponse;
import br.com.pdv.adapter.outbound.integration.repository.ProductRepository;
import br.com.pdv.adapter.outbound.integration.repository.entity.ProductEntity;
import br.com.pdv.domain.ports.outbound.GetListCategoryProductAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Component
@AllArgsConstructor
@Log4j2
public class GetListCategoryProductAdapter implements GetListCategoryProductAdapterPort {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	
	@Override
	public CategoryProductResponse listProductsByCategory(Long categoryId) {		
		List<ProductEntity> products = productRepository.findByCategoryId(categoryId);
		
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
