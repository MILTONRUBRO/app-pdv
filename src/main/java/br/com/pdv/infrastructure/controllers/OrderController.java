package br.com.pdv.infrastructure.controllers;


import br.com.pdv.application.usecase.GetAllOrdersOrdenedInteractor;
import br.com.pdv.application.usecase.GetOrderPaymentSatusInteractor;
import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.application.usecase.UpdateOrderStatusInteractor;
import br.com.pdv.domain.entity.ItemOrder;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.mappers.ItemOrderDTOMapper;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.controllers.request.OrderRequest;
import br.com.pdv.infrastructure.controllers.request.OrderWithItemsRequest;
import br.com.pdv.infrastructure.controllers.request.UpdateOrderStatusRequest;
import br.com.pdv.infrastructure.controllers.response.OrdersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Log4j2
public class OrderController {

	private final OrderDTOMapper orderDTOMapper;
	private final OrderCreateInteractor createOrderUseCase;
	private final UpdateOrderStatusInteractor updateOrderStatusInteractor;
	private final GetOrderPaymentSatusInteractor getOrderPaymentSatusInteractor;
	private final GetAllOrdersOrdenedInteractor getAllOrdersOrdenedUseCase;

	public OrderController(OrderDTOMapper orderDTOMapper, OrderCreateInteractor createOrderUseCase,
						   UpdateOrderStatusInteractor updateOrderStatusInteractor, GetOrderPaymentSatusInteractor getOrderPaymentSatusInteractor, GetAllOrdersOrdenedInteractor getAllOrdersOrdenedUseCase) {
		this.orderDTOMapper = orderDTOMapper;
		this.createOrderUseCase = createOrderUseCase;
		this.updateOrderStatusInteractor = updateOrderStatusInteractor;
		this.getOrderPaymentSatusInteractor =getOrderPaymentSatusInteractor;
		this.getAllOrdersOrdenedUseCase = getAllOrdersOrdenedUseCase;
	}

	@Operation(summary = "Create a new order",
			description = "Creates a new order based on the provided document number.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Order created successfully"),
					@ApiResponse(responseCode = "400", description = "Invalid input")
			})
	@PostMapping
	public ResponseEntity<Void> createOrder(@RequestBody OrderRequest request) {
		log.info("POST Order Request: {}", request);
		Order order = orderDTOMapper.toOrder(request);
		Order orderCreated = createOrderUseCase.createOrder(order);
		URI location = URI.create("/orders/" + orderCreated.id());
		return ResponseEntity.created(location).build();
	}

	@Operation(summary = "Update the status of an order",
			description = "Updates the status of the specified order based on the provided status.",
			responses = {
					@ApiResponse(responseCode = "204", description = "Order status updated successfully"),
					@ApiResponse(responseCode = "404", description = "Order not found"),
					@ApiResponse(responseCode = "400", description = "Invalid input")
			})
	@PatchMapping("/{idOrder}")
	public ResponseEntity<Void> updateOrderStatus(@PathVariable Long idOrder, @RequestBody @Valid UpdateOrderStatusRequest updateOrderStatusRequest) {
		log.info("PATCH update status for Order ID: {}", idOrder);
		updateOrderStatusInteractor.updateOrderStatus(idOrder, updateOrderStatusRequest.status());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Operation(summary = "Checkout and create an order",
			description = "Creates an order with the specified items based on the provided document number.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Order created successfully"),
					@ApiResponse(responseCode = "400", description = "Invalid input")
			})
	@PostMapping("/checkout")
	public ResponseEntity<Void> checkout(@RequestBody OrderWithItemsRequest request) {
		log.info("POST Checkout Request: {}", request);
		Order order = orderDTOMapper.toOrderList(request);
		Order orderCreated = createOrderUseCase.createOrder(order);
		URI location = URI.create("/orders/" + orderCreated.id());
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{idOrder}/payments")
	public ResponseEntity<String>getPaymentOrderStatus(@PathVariable Long idOrder) {
		log.info("GET payment status for Order ID: {}", idOrder);
		String response = getOrderPaymentSatusInteractor.getOrderPaymentSatus(idOrder);
		return ResponseEntity.ok(response);
	}

	@GetMapping()
	public ResponseEntity<List<OrdersResponse>>getAllOrders() {
		log.info("GET all orders" );
		List<OrdersResponse>ordersResponse = getAllOrdersOrdenedUseCase.getAllOrdersOrdened();
		return ResponseEntity.ok(ordersResponse);
	}
}
