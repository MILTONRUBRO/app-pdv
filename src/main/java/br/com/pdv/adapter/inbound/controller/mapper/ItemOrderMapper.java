package br.com.pdv.adapter.inbound.controller.mapper;


import br.com.pdv.adapter.inbound.controller.request.ItemOrderRequest;
import br.com.pdv.domain.ItemOrder;
import br.com.pdv.domain.Order;
import br.com.pdv.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ItemOrderMapper {

    public ItemOrder requestMapper(ItemOrderRequest request) {
        var itemOrder = new ItemOrder();
        var order = new Order();
        order.setId(request.getOrderId());
        var product = new Product();
        product.setId(request.getProductId());
        itemOrder.setOrder(order);
        itemOrder.setProduto(product);
        itemOrder.setQuantity(request.getQuantity());
        return itemOrder;
    }
}
