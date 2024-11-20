package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);

    List<CategoryDTO> getAllCategories();

    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);

    void deleteCategory(Long categoryId);
}
