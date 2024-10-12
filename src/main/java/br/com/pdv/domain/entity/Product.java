package br.com.pdv.domain.entity;

import java.math.BigDecimal;

public record Product(Long id,
                      String name,
                      String description,
                      BigDecimal price,
                      Long idCategory) {

}

