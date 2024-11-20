package kz.com.alzhan.temirlan.dto;

import lombok.Data;

@Data
public class RegistrationRequestDTO {
    private String email;
    private String password;
    private String name;
    private String role; // For example: "USER", "ADMIN"
    private String contactInfo;
    private boolean isActive;
}