package br.com.pdv.core.applications.services;

import br.com.pdv.adapter.driven.infra.entity.ItemOrder;
import br.com.pdv.adapter.driven.infra.entity.Product;
import br.com.pdv.adapter.driven.infra.mapper.ItemOrderMapper;
import br.com.pdv.adapter.driven.infra.dto.request.ItemOrderRequest;
import br.com.pdv.core.applications.exceptions.InvalidQuantityException;
import br.com.pdv.core.applications.ports.repositories.ItemOrderRepositoryPort;
import br.com.pdv.core.domains.ports.in.ItemOrderServicePort;
import br.com.pdv.core.domains.ports.in.ProductServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
@AllArgsConstructor
public class ItemOrderServicePortImpl implements ItemOrderServicePort {

    private final ItemOrderRepositoryPort itemOrderRepositoryPort;
    private final ProductServicePort productServicePort;
    private final ItemOrderMapper itemOrderMapper;


    @Override
    public void addItem(ItemOrderRequest request) {
        var itemOrder = itemOrderMapper.requestMapper(request);
        var product = productServicePort.findById(itemOrder.getProduto().getId());
        this.calculateAndSetTotalValue(product, itemOrder);
        itemOrderRepositoryPort.save(itemOrder);
        log.info("Item pedido adicionado {}", itemOrder);
    }

    private void calculateAndSetTotalValue(ProductEntity product, ItemOrder itemOrder) {
        if (itemOrder.getQuantity() <= 0) {
            throw new InvalidQuantityException("Quantidade de itens é inválido.");
        } else {
            itemOrder.setTotalValue(product.getPrice().multiply(BigDecimal.valueOf(itemOrder.getQuantity())));
        }
    }

}
