package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Product;

import java.util.List;

public interface ProductGateway {

    List<Product> listProductByCategoryId(Long categoryId);
}
