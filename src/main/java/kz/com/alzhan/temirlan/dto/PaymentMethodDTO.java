package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentMethodDTO {
    Long id;
    Long userId; // Represent the user by their ID to keep the DTO lightweight
    String type; // Represent the PaymentType enum as a String for simpler data handling
    String details; // JSONB data represented as a String
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
