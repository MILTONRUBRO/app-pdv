package br.com.pdv.adapter.outbound.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pdv.adapter.outbound.integration.repository.entity.OrderEntity;
import br.com.pdv.adapter.outbound.integration.repository.entity.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Modifying
    @Query("UPDATE OrderEntity o SET o.status = :status WHERE o.id = :id")
    void updateOrderStatus(Long id, OrderStatus status);
}
