package br.com.pdv.core.applications.ports.repositories;

import br.com.pdv.adapter.driven.infra.entity.ItemOrder;
import br.com.pdv.adapter.driven.infra.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepositoryPort extends JpaRepository<ItemOrder,Long> {
}
