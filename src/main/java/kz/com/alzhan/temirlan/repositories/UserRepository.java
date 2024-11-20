package kz.com.alzhan.temirlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.com.alzhan.temirlan.entities.UserEntity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByRole(String role);

    List<UserEntity> findByIsActiveTrue();

    boolean existsByEmail(String email);

    List<UserEntity> findByCreatedAtBefore(LocalDateTime date);

    List<UserEntity> findByUpdatedAtAfter(LocalDateTime date);

    List<UserEntity> findByRoleAndIsActiveTrue(String role);

}

