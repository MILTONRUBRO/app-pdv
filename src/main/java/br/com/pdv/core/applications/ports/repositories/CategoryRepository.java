package br.com.pdv.core.applications.ports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pdv.adapter.driven.infra.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
