package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Customer;

public interface GetCustomerByDocumentAdapterPort {

    Customer getCustomer(String document);
}
