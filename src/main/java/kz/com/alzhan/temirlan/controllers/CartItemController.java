package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.CartItemDTO;
import kz.com.alzhan.temirlan.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/{itemId}")
    public CartItemDTO getCartItemById(@PathVariable Long itemId) {
        return cartItemService.getCartItemById(itemId);
    }

    @PutMapping("/{itemId}")
    public CartItemDTO updateCartItem(@PathVariable Long itemId, @RequestBody CartItemDTO cartItemDTO) {
        return cartItemService.updateCartItem(itemId, cartItemDTO);
    }

    @DeleteMapping("/{itemId}")
    public void deleteCartItem(@PathVariable Long itemId) {
        cartItemService.removeCartItem(itemId);
    }
}
