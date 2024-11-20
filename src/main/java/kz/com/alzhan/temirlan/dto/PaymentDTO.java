package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentDTO {
    Long id;
    Long orderId;
    BigDecimal amount;
    Long paymentMethodId;
    String status;
    String transactionId;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
