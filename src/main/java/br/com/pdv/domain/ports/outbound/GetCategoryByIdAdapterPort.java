package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Category;

public interface GetCategoryByIdAdapterPort {
	Category getCategoryById(Long id);
}
