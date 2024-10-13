package br.com.pdv.infrastructure.controllers;


import br.com.pdv.application.usecase.OrderCreateInteractor;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.controllers.request.OrderRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
@Log4j2
public class OrderController {

    private final OrderDTOMapper orderDTOMapper;
    private final OrderCreateInteractor createOrderUseCase;

    public OrderController(OrderDTOMapper orderDTOMapper, OrderCreateInteractor createOrderUseCase) {
        this.orderDTOMapper = orderDTOMapper;
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderRequest request) {
        log.info("POST Order Request: {}", request);
        Order order = orderDTOMapper.toProduct(request);
        Order orderCreated = createOrderUseCase.createOrder(order);
        URI location = URI.create("/orders/" + orderCreated.id());
        return ResponseEntity.created(location).build();
    }
}
