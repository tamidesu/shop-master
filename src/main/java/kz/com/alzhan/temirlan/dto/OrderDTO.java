package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    Long id;
    Long userId;
    List<OrderItemDTO> items;
    BigDecimal totalAmount;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
