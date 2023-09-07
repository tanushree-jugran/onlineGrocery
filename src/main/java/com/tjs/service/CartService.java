package com.tjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjs.entity.Cart;
import com.tjs.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void editCartItem(Cart cart) {
        cartRepository.save(cart);
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }
}
