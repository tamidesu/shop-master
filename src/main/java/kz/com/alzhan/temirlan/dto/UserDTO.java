package kz.com.alzhan.temirlan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    Long id;
    String email;
    String role; // For example: "USER", "ADMIN"
    String name;
    String contactInfo;
    boolean isActive;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
