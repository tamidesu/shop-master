package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.PaymentEntity;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import kz.com.alzhan.temirlan.entities.PaymentEntity.PaymentStatus;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findByOrderId(Long orderId);

    List<PaymentEntity> findByStatus(PaymentStatus status);

    Optional<PaymentEntity> findByTransactionId(String transactionId);

    List<PaymentEntity> findByCreatedAtBefore(LocalDateTime date);

    List<PaymentEntity> findByUpdatedAtAfter(LocalDateTime date);

    Long countByStatus(PaymentStatus status);

    List<PaymentEntity> findByPaymentMethodId(Long paymentMethodId);
}
