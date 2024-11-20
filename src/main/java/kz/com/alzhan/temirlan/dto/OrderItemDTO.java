package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Value;
import java.math.BigDecimal;

@Value
@Builder
public class OrderItemDTO {
    Long id;
    Long orderId;
    Long productId;
    Integer quantity;
    BigDecimal price;
}
