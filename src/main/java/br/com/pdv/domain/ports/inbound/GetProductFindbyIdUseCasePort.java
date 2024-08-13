package br.com.pdv.domain.ports.inbound;

import br.com.pdv.domain.Product;

public interface GetProductFindbyIdUseCasePort {

    Product execute(Long id);
}
