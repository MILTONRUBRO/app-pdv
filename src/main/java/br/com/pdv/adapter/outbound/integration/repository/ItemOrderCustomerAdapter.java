package br.com.pdv.adapter.outbound.integration.repository;

import br.com.pdv.config.exception.InvalidQuantityException;
import br.com.pdv.domain.ItemOrder;
import br.com.pdv.domain.ports.outbound.PostItemOrderAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Log4j2
public class ItemOrderCustomerAdapter implements PostItemOrderAdapterPort {

    private final ItemOrderRepository itemOrderRepositoryPort;



    @Override
    public void addItem(ItemOrder itemOrder) {

            var product = productServicePort.findById(itemOrder.getProduto().getId());
            this.calculateAndSetTotalValue(product, itemOrder);
            itemOrderRepositoryPort.save(itemOrder);
            log.info("Item pedido adicionado {}", itemOrder);


    }

    private void calculateAndSetTotalValue(Product product, ItemOrder itemOrder) {
        if (itemOrder.getQuantity() <= 0) {
            throw new InvalidQuantityException("Quantidade de itens é inválido.");
        } else {
            itemOrder.setTotalValue(product.getPrice().multiply(BigDecimal.valueOf(itemOrder.getQuantity())));
        }
    }
}
