package br.com.pdv.adapter.driven.infra.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.dto.request.ProductRequest;
import br.com.pdv.adapter.driven.infra.dto.response.ProductResponse;

@Component
public class ProductMapper {

	public Product requestMapper(ProductRequest request) {
		var product = new Product();
		BeanUtils.copyProperties(request, product);
		return product;
	}
	
	public ProductResponse responseMapper(Product product) {
		var productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
		return productResponse;
	}
	

}
