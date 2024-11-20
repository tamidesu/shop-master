package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.CartItemDTO;
import kz.com.alzhan.temirlan.entities.CartEntity;
import kz.com.alzhan.temirlan.entities.CartItemEntity;
import kz.com.alzhan.temirlan.entities.ProductEntity;
import kz.com.alzhan.temirlan.repositories.CartItemRepository;
import kz.com.alzhan.temirlan.repositories.CartRepository;
import kz.com.alzhan.temirlan.repositories.ProductRepository;
import kz.com.alzhan.temirlan.services.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartItemDTO getCartItemById(Long cartItemId) {
        CartItemEntity cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        return modelMapper.map(cartItem, CartItemDTO.class);
    }

    @Override
    public CartItemDTO addCartItem(Long cartId, CartItemDTO cartItemDTO) {
        CartEntity cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        ProductEntity product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItemEntity cartItem = modelMapper.map(cartItemDTO, CartItemEntity.class);
        cartItem.setCart(cart);
        cartItem.setProduct(product);

        CartItemEntity savedCartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(savedCartItem, CartItemDTO.class);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        CartItemEntity cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItemDTO updateCartItem(Long cartItemId, CartItemDTO cartItemDTO) {
        CartItemEntity existingCartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        existingCartItem.setQuantity(cartItemDTO.getQuantity());
        existingCartItem.setPrice(cartItemDTO.getPrice());

        CartItemEntity updatedCartItem = cartItemRepository.save(existingCartItem);
        return modelMapper.map(updatedCartItem, CartItemDTO.class);
    }
}
