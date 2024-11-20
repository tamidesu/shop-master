package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.ProductEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByNameIgnoreCase(String name);

    List<ProductEntity> findByCategoryId(Long categoryId);

    List<ProductEntity> findByPriceGreaterThan(BigDecimal price);

    List<ProductEntity> findByPriceLessThan(BigDecimal price);

    List<ProductEntity> findByCreatedAtBefore(LocalDateTime date);

    List<ProductEntity> findByUpdatedAtAfter(LocalDateTime date);

    boolean existsByName(String name);
}
