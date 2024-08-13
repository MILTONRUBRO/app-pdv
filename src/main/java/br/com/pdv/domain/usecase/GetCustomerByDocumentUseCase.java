package br.com.pdv.domain.usecase;

import br.com.pdv.domain.Customer;
import br.com.pdv.domain.ports.inbound.GetCustomerByDocumentUseCasePort;
import br.com.pdv.domain.ports.outbound.GetCustomerByDocumentAdapterPort;

public class GetCustomerByDocumentUseCase implements GetCustomerByDocumentUseCasePort {

    private final GetCustomerByDocumentAdapterPort getCustomerByDocumentAdapterPort;

    public GetCustomerByDocumentUseCase(GetCustomerByDocumentAdapterPort getCustomerByDocumentAdapterPort) {
        this.getCustomerByDocumentAdapterPort = getCustomerByDocumentAdapterPort;
    }

    @Override
    public Customer execute(String documentNumber) {
        return getCustomerByDocumentAdapterPort.getCustomer(documentNumber);
    }
}
