package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.response.CategoryProductResponse;

public interface CategoryServicePort {
	
	CategoryProductResponse listProductsByCategory(Long categoryId);

}
