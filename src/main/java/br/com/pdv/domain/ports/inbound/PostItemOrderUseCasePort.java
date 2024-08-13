package br.com.pdv.domain.ports.inbound;

import br.com.pdv.domain.ItemOrder;

public interface PostItemOrderUseCasePort {

    void execute(ItemOrder itemOrder);

}
