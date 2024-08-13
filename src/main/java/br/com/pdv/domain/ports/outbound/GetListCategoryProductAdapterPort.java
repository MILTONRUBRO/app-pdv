package br.com.pdv.domain.ports.outbound;

import br.com.pdv.adapter.inbound.controller.response.CategoryProductResponse;

public interface GetListCategoryProductAdapterPort {
	CategoryProductResponse listProductsByCategory(Long categoryId);
}
