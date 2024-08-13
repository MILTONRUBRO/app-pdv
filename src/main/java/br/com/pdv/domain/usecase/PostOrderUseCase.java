package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Customer;
import br.com.pdv.domain.Order;
import br.com.pdv.domain.OrderStatus;
import br.com.pdv.domain.ports.inbound.PostOrderUseCasePort;
import br.com.pdv.domain.ports.outbound.GetCustomerByDocumentAdapterPort;
import br.com.pdv.domain.ports.outbound.PostOrderAdapterPort;

import java.time.LocalDateTime;

public class PostOrderUseCase implements PostOrderUseCasePort {


    private final PostOrderAdapterPort postOrderAdapterPort;
    private final GetCustomerByDocumentAdapterPort getCustomerByDocumentAdapterPort;

    public PostOrderUseCase(PostOrderAdapterPort postCustomerServiceAdapterPort, GetCustomerByDocumentAdapterPort getCustomerByDocumentAdapterPort) {
        this.postOrderAdapterPort = postCustomerServiceAdapterPort;
        this.getCustomerByDocumentAdapterPort = getCustomerByDocumentAdapterPort;
    }

    @Override
    public String execute(Order order) {
        Customer c = getCustomerByDocumentAdapterPort.getCustomer(order.getCustomer().getDocument());
        order.setCustomer(c);
        order.setStatus(OrderStatus.DELIVERED);
        order.setData(LocalDateTime.now());
        return postOrderAdapterPort.save(order);
    }
}
