package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class AuditLogDTO {
    Long id;
    Long userId;
    String action;
    LocalDateTime timestamp;
    String details;
}
