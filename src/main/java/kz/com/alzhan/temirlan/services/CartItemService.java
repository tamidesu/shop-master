package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.CartItemDTO;

public interface CartItemService {

    CartItemDTO addCartItem(Long cartId, CartItemDTO cartItemDTO);

    CartItemDTO getCartItemById(Long cartItemId);

    CartItemDTO updateCartItem(Long cartItemId, CartItemDTO cartItemDTO);

    void removeCartItem(Long cartItemId);
}
