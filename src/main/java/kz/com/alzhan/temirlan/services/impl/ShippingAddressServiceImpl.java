package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.ShippingAddressDTO;
import kz.com.alzhan.temirlan.entities.ShippingAddressEntity;
import kz.com.alzhan.temirlan.repositories.ShippingAddressRepository;
import kz.com.alzhan.temirlan.services.ShippingAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShippingAddressDTO createShippingAddress(ShippingAddressDTO shippingAddressDTO) {
        ShippingAddressEntity shippingAddress = modelMapper.map(shippingAddressDTO, ShippingAddressEntity.class);
        ShippingAddressEntity savedAddress = shippingAddressRepository.save(shippingAddress);
        return modelMapper.map(savedAddress, ShippingAddressDTO.class);
    }

    @Override
    public ShippingAddressDTO getShippingAddressById(Long id) {
        ShippingAddressEntity shippingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping address not found"));
        return modelMapper.map(shippingAddress, ShippingAddressDTO.class);
    }

    @Override
    public List<ShippingAddressDTO> getAllShippingAddresses() {
        List<ShippingAddressEntity> addresses = shippingAddressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapper.map(address, ShippingAddressDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShippingAddressDTO> getShippingAddressesByUserId(Long userId) {
        List<ShippingAddressEntity> addresses = shippingAddressRepository.findByUserId(userId);
        return addresses.stream()
                .map(address -> modelMapper.map(address, ShippingAddressDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShippingAddressDTO updateShippingAddress(Long id, ShippingAddressDTO shippingAddressDTO) {
        ShippingAddressEntity existingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping address not found"));

        existingAddress.setAddressLine1(shippingAddressDTO.getAddressLine1());
        existingAddress.setAddressLine2(shippingAddressDTO.getAddressLine2());
        existingAddress.setCity(shippingAddressDTO.getCity());
        existingAddress.setState(shippingAddressDTO.getState());
        existingAddress.setPostalCode(shippingAddressDTO.getPostalCode());
        existingAddress.setCountry(shippingAddressDTO.getCountry());

        ShippingAddressEntity updatedAddress = shippingAddressRepository.save(existingAddress);
        return modelMapper.map(updatedAddress, ShippingAddressDTO.class);
    }

    @Override
    public void deleteShippingAddress(Long id) {
        if (!shippingAddressRepository.existsById(id)) {
            throw new RuntimeException("Shipping address not found");
        }
        shippingAddressRepository.deleteById(id);
    }
}
