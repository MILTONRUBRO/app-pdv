package br.com.pdv.infrastructure.controllers;

import br.com.pdv.application.gateways.ItemOrderGateway;
import br.com.pdv.application.usecase.AddItemOrderInteractor;
import br.com.pdv.domain.entity.ItemOrder;
import br.com.pdv.infrastructure.controllers.mappers.ItemOrderDTOMapper;
import br.com.pdv.infrastructure.controllers.request.ItemOrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-items")
@Log4j2
public class ItemOrderController {

    private final AddItemOrderInteractor addItemOrderUseCase;
    private final ItemOrderDTOMapper itemOrderDTOMapper;

    public ItemOrderController(ItemOrderDTOMapper itemOrderDTOMapper, AddItemOrderInteractor addItemOrderUseCase) {
        this.itemOrderDTOMapper = itemOrderDTOMapper;
        this.addItemOrderUseCase = addItemOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> addItem(@RequestBody ItemOrderRequest request) {
        log.info("POST AddItem Request: {}", request);
        ItemOrder itemOrder = itemOrderDTOMapper.toItemOrder(request);
        addItemOrderUseCase.addItemOrder(itemOrder);
        return ResponseEntity.noContent().build();
    }

}
