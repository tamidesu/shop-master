package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.PaymentMethodEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import kz.com.alzhan.temirlan.entities.PaymentMethodEntity.PaymentType;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {

    List<PaymentMethodEntity> findByUserId(Long userId);

    List<PaymentMethodEntity> findByType(PaymentType type);

    boolean existsByUserIdAndType(Long userId, PaymentType type);

    Optional<PaymentMethodEntity> findByUserIdAndType(Long userId, PaymentType type);

    List<PaymentMethodEntity> findByCreatedAtBefore(LocalDateTime date);

    List<PaymentMethodEntity> findByUpdatedAtAfter(LocalDateTime date);

}
