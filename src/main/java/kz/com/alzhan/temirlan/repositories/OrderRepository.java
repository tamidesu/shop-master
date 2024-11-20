package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.OrderEntity;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserId(Long userId);

    List<OrderEntity> findByStatus(OrderEntity.OrderStatus status);

    List<OrderEntity> findByCreatedAtBefore(LocalDateTime date);

    List<OrderEntity> findByCreatedAtAfter(LocalDateTime date);

    Long countByUserIdAndStatus(Long userId, OrderEntity.OrderStatus status);

    List<OrderEntity> findByUserIdAndStatus(Long userId, OrderEntity.OrderStatus status);
}
