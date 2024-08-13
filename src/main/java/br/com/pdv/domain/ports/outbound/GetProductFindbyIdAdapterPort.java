package br.com.pdv.domain.ports.outbound;

import br.com.pdv.domain.Product;

public interface GetProductFindbyIdAdapterPort {

    Product getProductById(Long id);
}
