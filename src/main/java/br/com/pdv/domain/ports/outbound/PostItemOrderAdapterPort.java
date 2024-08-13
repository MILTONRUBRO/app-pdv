package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Customer;
import br.com.pdv.domain.ItemOrder;

public interface PostItemOrderAdapterPort {

    void addItem(ItemOrder itemOrder);
}
