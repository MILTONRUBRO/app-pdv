package br.com.pdv.infrastructure.controllers;


import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.application.usecase.GetOrderPaymentSatusInteractor;
import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.application.usecase.UpdateOrderStatusInteractor;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.controllers.request.OrderRequest;
import br.com.pdv.infrastructure.controllers.request.UpdateOrderStatusRequest;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/orders")
@Log4j2
public class OrderController {

    private final OrderDTOMapper orderDTOMapper;
    private final OrderCreateInteractor createOrderUseCase;
    private final UpdateOrderStatusInteractor updateOrderStatusInteractor;
    private final GetOrderPaymentSatusInteractor getOrderPaymentSatusInteractor;
    
	public OrderController(OrderDTOMapper orderDTOMapper, OrderCreateInteractor createOrderUseCase,
			UpdateOrderStatusInteractor updateOrderStatusInteractor,
			GetOrderPaymentSatusInteractor getOrderPaymentSatusInteractor) {
		this.orderDTOMapper = orderDTOMapper;
		this.createOrderUseCase = createOrderUseCase;
		this.updateOrderStatusInteractor = updateOrderStatusInteractor;
		this.getOrderPaymentSatusInteractor = getOrderPaymentSatusInteractor;
	}

	@PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderRequest request) {
        log.info("POST Order Request: {}", request);
        Order order = orderDTOMapper.toProduct(request);
        Order orderCreated = createOrderUseCase.createOrder(order);
        URI location = URI.create("/orders/" + orderCreated.id());
        return ResponseEntity.created(location).build();
    }
    
	@PatchMapping("/{idOrder}")
	public ResponseEntity<Void> updateOrderStatus(@PathVariable Long idOrder, @RequestBody @Valid UpdateOrderStatusRequest updateOrderStatusRequest) {
		log.info("PATCH update status for Order ID: {}", idOrder);
		updateOrderStatusInteractor.updateOrderStatus(idOrder, updateOrderStatusRequest.status());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{idOrder}/payments")
	public ResponseEntity<String>getPaymentOrderStatus(@PathVariable Long idOrder) {
		log.info("GET payment status for Order ID: {}", idOrder);
		String response = getOrderPaymentSatusInteractor.getOrderPaymentSatus(idOrder);
		return ResponseEntity.ok(response);
	}
	
}
