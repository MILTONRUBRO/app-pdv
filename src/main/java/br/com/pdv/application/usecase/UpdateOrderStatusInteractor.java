package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.OrderGateway;

public class UpdateOrderStatusInteractor {
	
	  private final OrderGateway orderGateway;

	public UpdateOrderStatusInteractor(OrderGateway orderGateway) {
		this.orderGateway = orderGateway;
	}
	
	
	public void updateOrderStatus(Long idOrder, String status) {
		orderGateway.updateOrderStatus(idOrder, status);
	}

}
