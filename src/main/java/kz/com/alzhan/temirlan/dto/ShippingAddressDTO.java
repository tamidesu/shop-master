package kz.com.alzhan.temirlan.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ShippingAddressDTO {
    Long id;
    Long userId;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String postalCode;
    String country;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
