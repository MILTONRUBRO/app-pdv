package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Customer;

public interface PostCustomerAdapterPort {

    String saveCustomer(Customer customer );
}
