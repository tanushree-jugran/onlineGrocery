package com.tjs.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tjs.entity.Cart;

import com.tjs.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
        cartService.addToCart(cart);
        return ResponseEntity.ok("Product added to cart.");
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editCartItem(@RequestBody Cart cart) {
        cartService.editCartItem(cart);
        return ResponseEntity.ok("Cart item updated.");
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.ok("Product removed from cart.");
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Cart>> getCartByCustomerId(@PathVariable Long customerId) {
        List<Cart> cartItems = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(cartItems);
    }
}
