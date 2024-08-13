package br.com.pdv.adapter.inbound.controller.mapper;

import br.com.pdv.adapter.driven.infra.dto.request.OrderRequest;
import br.com.pdv.adapter.driven.infra.entity.Order;
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
