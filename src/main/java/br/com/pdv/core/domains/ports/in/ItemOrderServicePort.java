package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.dto.request.ItemOrderRequest;

public interface ItemOrderServicePort {
	
	void addItem(ItemOrderRequest orderRequest);
	//void delete(Long idProduct);
	//void update(ProductRequest request, Long idProduct);

}
