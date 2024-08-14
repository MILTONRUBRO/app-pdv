package br.com.pdv.adapter.outbound.integration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pdv.adapter.outbound.integration.repository.entity.ItemOrderEntity;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity,Long> {
}
