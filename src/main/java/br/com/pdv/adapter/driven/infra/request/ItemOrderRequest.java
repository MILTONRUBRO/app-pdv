package br.com.pdv.adapter.driven.infra.request;

import lombok.Data;

@Data
public class ItemOrderRequest {

	private int quantity;
	private Long orderId ;
	private Long productId ;

}
