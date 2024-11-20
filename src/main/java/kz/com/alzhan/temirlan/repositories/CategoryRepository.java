package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.CategoryEntity;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(String name);

    List<CategoryEntity> findByParentCategoryId(Long parentCategoryId);

    List<CategoryEntity> findByParentCategoryIsNull();

    List<CategoryEntity> findByParentCategory(CategoryEntity parentCategory);

    boolean existsByName(String name);
}
