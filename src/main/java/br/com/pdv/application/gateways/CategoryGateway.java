package br.com.pdv.application.gateways;

import br.com.pdv.domain.entity.Category;
import br.com.pdv.domain.entity.Product;

import java.util.List;

public interface CategoryGateway {

    Category findById(Long categoryId);

}
