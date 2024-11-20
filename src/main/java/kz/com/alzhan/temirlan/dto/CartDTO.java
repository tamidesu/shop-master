package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CartDTO {
    Long id;
    Long userId;
    List<CartItemDTO> items;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
