package br.com.pdv.adapter.inbound.controller;


import br.com.pdv.adapter.inbound.controller.mapper.OrderMapper;
import br.com.pdv.adapter.inbound.controller.request.OrderRequest;
import br.com.pdv.adapter.inbound.controller.request.UpdateOrderStatusRequest;
import br.com.pdv.domain.ports.inbound.PatchOrderUseCasePort;
import br.com.pdv.domain.ports.inbound.PostOrderUseCasePort;
import br.com.pdv.domain.usecase.PatchOrderUseCase;
import br.com.pdv.domain.usecase.PostItemOrderUseCase;
import br.com.pdv.domain.usecase.PostOrderUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Log4j2
public class OrderController {

	private final PostOrderUseCasePort postItemOrderUseCase;
	private final PatchOrderUseCasePort patchOrderUseCase;

	private final OrderMapper orderMapper;

	@PostMapping
	public ResponseEntity<Void> createOrder(@RequestBody OrderRequest request) {
		log.info("POST Order Request: {}", request);
		var order = orderMapper.requestMapper(request);
		postItemOrderUseCase.execute(order);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{idOrder}")
	public ResponseEntity<Void> updateOrderStatus(@PathVariable Long idOrder, @RequestBody @Valid UpdateOrderStatusRequest updateOrderStatusRequest) {
		log.info("PATCH update status for Order ID: {}", idOrder);
		patchOrderUseCase.execute(idOrder, updateOrderStatusRequest.getStatus());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
