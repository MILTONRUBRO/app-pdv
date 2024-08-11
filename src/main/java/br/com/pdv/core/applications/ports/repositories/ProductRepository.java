package br.com.pdv.core.applications.ports.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pdv.adapter.driven.infra.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategoryId(Long categoryId);

}
