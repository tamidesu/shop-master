package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.ShippingAddressDTO;
import kz.com.alzhan.temirlan.services.ShippingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shipping-addresses")
public class ShippingAddressController {

    private final ShippingAddressService shippingAddressService;

    @PostMapping("/")
    public ShippingAddressDTO createShippingAddress(@RequestBody ShippingAddressDTO shippingAddressDTO) {
        return shippingAddressService.createShippingAddress(shippingAddressDTO);
    }

    @GetMapping("/{id}")
    public ShippingAddressDTO getShippingAddressById(@PathVariable Long id) {
        return shippingAddressService.getShippingAddressById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ShippingAddressDTO> getShippingAddressesByUserId(@PathVariable Long userId) {
        return shippingAddressService.getShippingAddressesByUserId(userId);
    }

    @PutMapping("/{id}")
    public ShippingAddressDTO updateShippingAddress(@PathVariable Long id, @RequestBody ShippingAddressDTO shippingAddressDTO) {
        return shippingAddressService.updateShippingAddress(id, shippingAddressDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteShippingAddress(@PathVariable Long id) {
        shippingAddressService.deleteShippingAddress(id);
    }

    @GetMapping("/")
    public List<ShippingAddressDTO> getAllShippingAddresses() {
        return shippingAddressService.getAllShippingAddresses();
    }
}
