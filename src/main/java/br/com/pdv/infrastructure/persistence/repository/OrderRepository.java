package br.com.pdv.infrastructure.persistence.repository;

import br.com.pdv.domain.entity.OrderStatus;
import br.com.pdv.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Modifying
    @Query("UPDATE OrderEntity o SET o.status = :status WHERE o.id = :id")
    void updateOrderStatus(Long id, OrderStatus status);
}
