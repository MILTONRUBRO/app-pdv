package br.com.pdv.adapter.driven.infra.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;

@Component
public class ProductMapper {

	public Product requestMapper(ProductRequest request) {
		var product = new Product();
		BeanUtils.copyProperties(request, product);
		return product;
	}

}
