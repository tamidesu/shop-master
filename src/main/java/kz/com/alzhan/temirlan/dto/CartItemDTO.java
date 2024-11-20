package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class CartItemDTO {
    Long id;
    Long cartId;
    Long productId;
    Integer quantity;
    BigDecimal price;
}
