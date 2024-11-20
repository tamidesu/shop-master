package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.AuditLogEntity;
import java.util.List;
import java.time.LocalDateTime;

public interface AuditLogRepository extends JpaRepository<AuditLogEntity, Long> {

    List<AuditLogEntity> findByUserId(Long userId);

    List<AuditLogEntity> findByAction(AuditLogEntity.ActionType action);

    List<AuditLogEntity> findByUserIdAndAction(Long userId, AuditLogEntity.ActionType action);

    List<AuditLogEntity> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    List<AuditLogEntity> findByUserIdAndTimestampBetween(Long userId, LocalDateTime start, LocalDateTime end);
}
