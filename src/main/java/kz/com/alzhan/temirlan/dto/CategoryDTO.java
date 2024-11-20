package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CategoryDTO {
    Long id;
    String name;
    Long parentCategoryId;
    List<Long> subCategoryIds;
}
