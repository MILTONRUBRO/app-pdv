package br.com.pdv.adapter.driven.infra.mapper;

import br.com.pdv.adapter.driven.infra.entity.Order;
import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.request.OrderRequest;
import br.com.pdv.adapter.driven.infra.request.ProductRequest;
import br.com.pdv.adapter.driven.infra.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

	public Order requestMapper(OrderRequest request) {
		var order = new Order();
		BeanUtils.copyProperties(request, order);
		return order;
	}
	

	

}
