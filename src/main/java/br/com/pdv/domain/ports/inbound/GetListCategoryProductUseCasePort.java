package br.com.pdv.domain.ports.inbound;

import br.com.pdv.adapter.inbound.controller.response.CategoryProductResponse;

public interface GetListCategoryProductUseCasePort {

	CategoryProductResponse listProductsByCategory(Long categoryId);

}
