package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Customer;
import br.com.pdv.domain.ports.inbound.PostCustomerUseCasePort;
import br.com.pdv.domain.ports.outbound.PostCustomerAdapterPort;

public class PostCustomerUseCase implements PostCustomerUseCasePort {

    private final PostCustomerAdapterPort postCustomerServiceAdapterPort;

    public PostCustomerUseCase(PostCustomerAdapterPort postCustomerServiceAdapterPort) {
        this.postCustomerServiceAdapterPort = postCustomerServiceAdapterPort;
    }

    @Override
    public String execute(Customer customer) {
       return postCustomerServiceAdapterPort.saveCustomer(customer);
    }
}
