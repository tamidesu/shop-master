package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ForeignProductDTO {
    Long id;
    String sourceUrl;
    String name;
    String description;
    BigDecimal price;
    Long categoryId; // Use the category ID instead of the full CategoryEntity to simplify the DTO
    List<String> images;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
