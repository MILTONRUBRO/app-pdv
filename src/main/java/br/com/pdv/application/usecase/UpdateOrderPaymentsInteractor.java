package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.OrderGateway;

public class UpdateOrderPaymentsInteractor {

	  private final OrderGateway orderGateway;

	public UpdateOrderPaymentsInteractor(OrderGateway orderGateway) {
		this.orderGateway = orderGateway;
	}
	
	
	public void updateOrderPayments(Long idOrder, String status) {
		orderGateway.updateOrderPayments(idOrder, status);
	}

}
