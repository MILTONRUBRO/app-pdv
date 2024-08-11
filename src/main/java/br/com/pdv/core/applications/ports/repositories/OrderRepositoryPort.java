package br.com.pdv.core.applications.ports.repositories;

import br.com.pdv.adapter.driven.infra.entity.Order;
import br.com.pdv.adapter.driven.infra.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryPort extends JpaRepository<Order,Long> {

    @Modifying
    @Query("UPDATE Order o SET o.status = :status WHERE o.id = :id")
    void updateOrderStatus(Long id, OrderStatus status);
}
