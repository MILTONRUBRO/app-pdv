package br.com.pdv.core.applications.ports.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pdv.adapter.driven.infra.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory(Long categoryId);

}
