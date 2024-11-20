package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.ForeignProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ForeignProductRepository extends JpaRepository<ForeignProductEntity, Long> {

    Optional<ForeignProductEntity> findByName(String name);

    List<ForeignProductEntity> findByCategoryId(Long categoryId);

    List<ForeignProductEntity> findByPriceGreaterThan(BigDecimal price);

    List<ForeignProductEntity> findBySourceUrl(String sourceUrl);

    List<ForeignProductEntity> findByCreatedAtBefore(LocalDateTime date);

    List<ForeignProductEntity> findByUpdatedAtAfter(LocalDateTime date);
}
