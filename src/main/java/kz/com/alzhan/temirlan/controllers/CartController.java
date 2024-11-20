package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.CartDTO;
import kz.com.alzhan.temirlan.dto.CartItemDTO;
import kz.com.alzhan.temirlan.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public CartDTO getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/items")
    public CartDTO addItemToCart(@PathVariable Long userId, @RequestBody CartItemDTO cartItemDTO) {
        return cartService.addItemToCart(userId, cartItemDTO);
    }

    @DeleteMapping("/{userId}/items/{itemId}")
    public CartDTO removeItemFromCart(@PathVariable Long userId, @PathVariable Long itemId) {
        return cartService.removeItemFromCart(userId, itemId);
    }
}
