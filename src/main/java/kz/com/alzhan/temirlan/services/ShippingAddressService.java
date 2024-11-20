package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.ShippingAddressDTO;
import java.util.List;

public interface ShippingAddressService {

    ShippingAddressDTO createShippingAddress(ShippingAddressDTO shippingAddressDTO);

    ShippingAddressDTO getShippingAddressById(Long id);

    List<ShippingAddressDTO> getAllShippingAddresses();

    List<ShippingAddressDTO> getShippingAddressesByUserId(Long userId);

    ShippingAddressDTO updateShippingAddress(Long id, ShippingAddressDTO shippingAddressDTO);

    void deleteShippingAddress(Long id);
}
