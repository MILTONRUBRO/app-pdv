package br.com.pdv.adapter.driven.infra.mapper;

import br.com.pdv.adapter.driven.infra.entity.ItemOrder;
import br.com.pdv.adapter.driven.infra.entity.Order;
import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.dto.request.ItemOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class ItemOrderMapper {

	public ItemOrder requestMapper(ItemOrderRequest request) {
		var itemOrder = new ItemOrder();
		var order = new Order();
		order.setId(request.getOrderId());
		var  product = new ProductEntity();
		product.setId(request.getProductId());
		itemOrder.setOrder(order);
		itemOrder.setProduto(product);
		itemOrder.setQuantity(request.getQuantity());
		return itemOrder;
	}
	

	

}
