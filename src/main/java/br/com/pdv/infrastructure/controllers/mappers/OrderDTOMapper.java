package br.com.pdv.infrastructure.controllers.mappers;

import br.com.pdv.domain.entity.Customer;
import br.com.pdv.domain.entity.ItemOrder;
import br.com.pdv.domain.entity.Order;
import br.com.pdv.infrastructure.controllers.request.OrderRequest;
import br.com.pdv.infrastructure.controllers.request.OrderWithItemsRequest;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDTOMapper {

    private final ItemOrderDTOMapper itemOrderMapper = new ItemOrderDTOMapper();

    public Order toOrder(OrderRequest request) {
        Customer customer = new Customer(null, null, null, request.documentNumber());
        return new Order(null, null, null, null, customer, null, null);
    }

    public Order toOrderList(OrderWithItemsRequest request) {


        // Cria um novo objeto Customer
        Customer customer = new Customer(null, null, null, request.documentNumber());

        // Converte a lista de ItemOrderRequest para ItemOrder
        List<ItemOrder> itemsOrder = request.itemsOrder().stream()
                .map(itemOrderMapper::toItemOrder) // Mapeia usando o ItemOrderDTOMapper
                .collect(Collectors.toList());

        // Cria e retorna um novo objeto Order
        return new Order(
                null, // id será gerado pelo banco de dados
                null, // data pode ser definida posteriormente
                null, // status pode ser definido posteriormente
                null, // totalValue pode ser calculado depois
                customer,
                null, // payments podem ser definidos posteriormente
                itemsOrder
        );
    }
}
