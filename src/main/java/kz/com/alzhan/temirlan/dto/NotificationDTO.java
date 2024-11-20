package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class NotificationDTO {
    Long id;
    Long userId; // Use the user ID instead of the full UserEntity to keep the DTO simple
    String message;
    boolean isRead;
    LocalDateTime createdAt;
}
