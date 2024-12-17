package br.com.pdv.infrastructure.gateways.repository;

import br.com.pdv.application.exception.BadRequestException;
import br.com.pdv.application.exception.InvalidQuantityException;
import br.com.pdv.application.gateways.ItemOrderGateway;
import br.com.pdv.application.gateways.ProductGateway;
import br.com.pdv.domain.entity.ItemOrder;
import br.com.pdv.domain.entity.Product;
import br.com.pdv.infrastructure.gateways.mapper.ItemOrderEntityMapper;
import br.com.pdv.infrastructure.persistence.entity.ItemOrderEntity;
import br.com.pdv.infrastructure.persistence.repository.ItemOrderRepository;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
public class ItemOrderRepositoryGateway implements ItemOrderGateway {

    private final ItemOrderRepository itemOrderRepository;
    private final ItemOrderEntityMapper itemOrderEntityMapper;
    private final ProductGateway productGateway;

    public ItemOrderRepositoryGateway(ItemOrderRepository itemOrderRepository, ItemOrderEntityMapper itemOrderEntityMapper, ProductGateway productGateway) {
        this.itemOrderRepository = itemOrderRepository;
        this.itemOrderEntityMapper = itemOrderEntityMapper;
        this.productGateway = productGateway;
    }

    @Override
    public ItemOrder addItemOrder(ItemOrder itemOrder) {
        try {
            Product product = productGateway.findById(itemOrder.productId());
            ItemOrderEntity entity = itemOrderEntityMapper.toEntity(itemOrder);
            this.calculateAndSetTotalValue(product, entity);
            itemOrderRepository.save(entity);
            log.info("Item pedido adicionado {}", entity);
            return itemOrderEntityMapper.toDomainObj(entity);
        } catch (Exception ex) {
            throw new BadRequestException("Houve um erro na chamada, favor entrar em contato com o TI.");
        }
    }

    private void calculateAndSetTotalValue(Product product, ItemOrderEntity itemOrder) {
        if (itemOrder.getQuantity() <= 0) {
            throw new InvalidQuantityException("Quantidade de itens é inválido.");
        } else {
            itemOrder.setTotalValue(product.price().multiply(BigDecimal.valueOf(itemOrder.getQuantity())));
        }
    }
}
