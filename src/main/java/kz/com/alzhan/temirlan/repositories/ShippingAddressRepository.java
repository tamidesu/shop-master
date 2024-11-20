package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.ShippingAddressEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddressEntity, Long> {

    List<ShippingAddressEntity> findByUserId(Long userId);

    Optional<ShippingAddressEntity> findByUserIdAndAddressLine1(Long userId, String addressLine1);

    boolean existsByUserIdAndPostalCode(Long userId, String postalCode);

    List<ShippingAddressEntity> findByCityIgnoreCase(String city);

    List<ShippingAddressEntity> findByCreatedAtBefore(LocalDateTime date);

    List<ShippingAddressEntity> findByUpdatedAtAfter(LocalDateTime date);
}
