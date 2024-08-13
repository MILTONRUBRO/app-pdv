package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.ItemOrder;
import br.com.pdv.domain.Order;

public interface PostOrderAdapterPort {

    String save(Order order);
}
