package br.com.pdv.application.usecase;

import br.com.pdv.application.gateways.OrderGateway;

public class GetOrderPaymentSatusInteractor {

	private final OrderGateway orderGateway;

	public GetOrderPaymentSatusInteractor(OrderGateway orderGateway) {
		this.orderGateway = orderGateway;
	}

	public String getOrderPaymentSatus(Long idOrder) {
		return orderGateway.getOrderPaymentSatus(idOrder);
	}

}
