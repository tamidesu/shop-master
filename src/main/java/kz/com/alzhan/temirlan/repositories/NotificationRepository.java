package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.NotificationEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    List<NotificationEntity> findByUserId(Long userId);

    List<NotificationEntity> findByUserIdAndIsReadFalse(Long userId);

    List<NotificationEntity> findByCreatedAtBefore(LocalDateTime date);

    List<NotificationEntity> findByCreatedAtAfter(LocalDateTime date);

    long countByUserIdAndIsReadFalse(Long userId);
}
