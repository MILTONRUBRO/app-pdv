package br.com.pdv.domain.ports.inbound;

import br.com.pdv.domain.ItemOrder;
import br.com.pdv.domain.Order;

public interface PostOrderUseCasePort {

    String execute(Order order);

}
