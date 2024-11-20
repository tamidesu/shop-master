package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.CartDTO;
import kz.com.alzhan.temirlan.dto.CartItemDTO;
import kz.com.alzhan.temirlan.entities.CartEntity;
import kz.com.alzhan.temirlan.entities.CartItemEntity;
import kz.com.alzhan.temirlan.entities.UserEntity;
import kz.com.alzhan.temirlan.repositories.CartRepository;
import kz.com.alzhan.temirlan.repositories.UserRepository;
import kz.com.alzhan.temirlan.repositories.CartItemRepository;
import kz.com.alzhan.temirlan.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartDTO getCartByUserId(Long userId) {
        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));
        return modelMapper.map(cart, CartDTO.class);
    }

    @Override
    public CartDTO addItemToCart(Long userId, CartItemDTO cartItemDTO) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        CartEntity cart = cartRepository.findByUserId(userId)
                .orElse(new CartEntity(user));

        CartItemEntity cartItem = modelMapper.map(cartItemDTO, CartItemEntity.class);
        cartItem.setCart(cart);
        cart.getItems().add(cartItem);

        CartEntity updatedCart = cartRepository.save(cart);
        return modelMapper.map(updatedCart, CartDTO.class);
    }

    @Override
    public CartDTO removeItemFromCart(Long userId, Long cartItemId) {
        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));

        cart.getItems().removeIf(item -> item.getId().equals(cartItemId));
        CartEntity updatedCart = cartRepository.save(cart);
        return modelMapper.map(updatedCart, CartDTO.class);
    }

    @Override
    public CartDTO clearCart(Long userId) {
        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));

        cart.getItems().clear();
        CartEntity updatedCart = cartRepository.save(cart);
        return modelMapper.map(updatedCart, CartDTO.class);
    }

    @Override
    public List<CartItemDTO> getItemsInCart(Long userId) {
        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));

        return cart.getItems().stream()
                .map(item -> modelMapper.map(item, CartItemDTO.class))
                .collect(Collectors.toList());
    }
}
