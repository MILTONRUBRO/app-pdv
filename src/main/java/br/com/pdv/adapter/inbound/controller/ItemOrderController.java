package br.com.pdv.adapter.inbound.controller;

import br.com.pdv.adapter.inbound.controller.mapper.ItemOrderMapper;
import br.com.pdv.adapter.inbound.controller.request.ItemOrderRequest;
import br.com.pdv.domain.ports.inbound.PostItemOrderUseCasePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-items")
@AllArgsConstructor
@Log4j2
public class ItemOrderController {

	private final PostItemOrderUseCasePort postItemOrderUseCasePort;
	private final ItemOrderMapper itemOrderMapper;

	@PostMapping
	public ResponseEntity<Void> addItem(@RequestBody ItemOrderRequest request) {
		log.info("POST AddItem Request: {}", request);
		var itemOrder = itemOrderMapper.requestMapper(request);
		postItemOrderUseCasePort.execute(itemOrder);
		return ResponseEntity.noContent().build();
	}


}
