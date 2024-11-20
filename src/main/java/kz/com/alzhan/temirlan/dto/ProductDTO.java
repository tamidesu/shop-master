package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductDTO {
    Long id;
    String name;
    String description;
    BigDecimal price;
    Long categoryId;
    List<String> images;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
