package br.com.pdv.infrastructure.controllers.request;

import java.util.List;

public record OrderWithItemsRequest(String documentNumber,List<ItemOrderRequest> itemsOrder) {

}
