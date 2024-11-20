package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.CartDTO;
import kz.com.alzhan.temirlan.dto.CartItemDTO;
import java.util.List;

public interface CartService {
    CartDTO getCartByUserId(Long userId);
    CartDTO addItemToCart(Long userId, CartItemDTO cartItemDTO);
    CartDTO removeItemFromCart(Long userId, Long cartItemId);
    CartDTO clearCart(Long userId);
    List<CartItemDTO> getItemsInCart(Long userId);
}
