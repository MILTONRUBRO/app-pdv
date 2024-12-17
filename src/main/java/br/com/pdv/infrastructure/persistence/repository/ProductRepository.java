package br.com.pdv.infrastructure.persistence.repository;

import br.com.pdv.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategoryId(Long categoryId);

}
