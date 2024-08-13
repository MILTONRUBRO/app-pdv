package br.com.pdv.domain.ports.inbound;

import br.com.pdv.domain.Category;

public interface GetCategoryByIDUseCasePort {
	
	Category execute(Long id);

}
