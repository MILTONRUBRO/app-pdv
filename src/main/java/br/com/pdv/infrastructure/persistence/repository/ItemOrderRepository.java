package br.com.pdv.infrastructure.persistence.repository;

import br.com.pdv.infrastructure.persistence.entity.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity,Long> {
}

