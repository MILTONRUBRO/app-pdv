package br.com.pdv.core.domains.ports.in;

import br.com.pdv.adapter.driven.infra.request.ItemOrderRequest;
import br.com.pdv.adapter.driven.infra.request.OrderRequest;

public interface ItemOrderServicePort {
	
	void addItem(ItemOrderRequest orderRequest);
	//void delete(Long idProduct);
	//void update(ProductRequest request, Long idProduct);

}
