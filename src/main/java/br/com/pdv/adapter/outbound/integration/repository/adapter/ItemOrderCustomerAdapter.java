package br.com.pdv.adapter.outbound.integration.repository.adapter;

import br.com.pdv.adapter.inbound.controller.mapper.ItemOrderMapper;
import br.com.pdv.adapter.outbound.integration.repository.ItemOrderRepository;
import br.com.pdv.adapter.outbound.integration.repository.entity.ItemOrderEntity;
import br.com.pdv.config.exception.InvalidQuantityException;
import br.com.pdv.domain.ItemOrder;
import br.com.pdv.domain.Product;
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
    private final GetProductFindByIdAdapter getProductFindByIdAdapter;
    private final ItemOrderMapper itemOrderMapper;

    @Override
    public void addItem(ItemOrder itemOrder) {

            var product = getProductFindByIdAdapter.getProductById(itemOrder.getProduto().getId());
            this.calculateAndSetTotalValue(product, itemOrder);
            
            ItemOrderEntity entity = itemOrderMapper.toEntity(itemOrder);
            
            itemOrderRepositoryPort.save(entity);
            log.info("Item pedido adicionado {}", entity);


    }

    private void calculateAndSetTotalValue(Product product, ItemOrder itemOrder) {
        if (itemOrder.getQuantity() <= 0) {
            throw new InvalidQuantityException("Quantidade de itens é inválido.");
        } else {
            itemOrder.setTotalValue(product.getPrice().multiply(BigDecimal.valueOf(itemOrder.getQuantity())));
        }
    }
}
