package br.com.pdv.adapter.outbound.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pdv.adapter.driven.infra.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
