package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.OrderItemEntity;
import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    List<OrderItemEntity> findByOrderId(Long orderId);

    List<OrderItemEntity> findByProductId(Long productId);

    Optional<OrderItemEntity> findByOrderIdAndProductId(Long orderId, Long productId);

    Long countByOrderId(Long orderId);

    List<OrderItemEntity> findByQuantityGreaterThan(Integer quantity);
}
