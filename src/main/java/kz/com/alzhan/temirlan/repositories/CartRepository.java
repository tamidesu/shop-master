package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.CartEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    Optional<CartEntity> findByUserId(Long userId);

    boolean existsByUserId(Long userId);

    List<CartEntity> findByCreatedAtBefore(LocalDateTime date);

    List<CartEntity> findByUpdatedAtAfter(LocalDateTime date);

}

