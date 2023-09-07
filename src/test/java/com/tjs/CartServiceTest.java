package com.tjs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.tjs.entity.Cart;
import com.tjs.repository.CartRepository;
import com.tjs.service.CartService;

@SpringBootTest
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    @Test
    public void testAddToCart() {
        Cart cart = new Cart(1L, 1L, 2);

        when(cartRepository.save(cart)).thenReturn(cart);

        cartService.addToCart(cart);

        verify(cartRepository, times(1)).save(cart);
    }

    public void editCartItem(Cart updatedCart) {
        // 1. Retrieve the existing cart item by its ID
        Cart existingCart = cartRepository.findById(updatedCart.getId())
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        // 2. Update the fields of the existing cart item with the new values
        existingCart.setCustomerId(updatedCart.getCustomerId());
        existingCart.setProductId(updatedCart.getProductId());
        existingCart.setQuantity(updatedCart.getQuantity());

        // 3. Save the updated cart item back to the database
        cartRepository.save(existingCart);
    }


    @Test
    public void testRemoveFromCart() {
        Long cartId = 1L;
        doNothing().when(cartRepository).deleteById(cartId);

        cartService.removeFromCart(cartId);

        verify(cartRepository, times(1)).deleteById(cartId);
    }

    @Test
    public void testGetCartByCustomerId() {
        Long customerId = 1L;
        List<Cart> cartItems = new ArrayList<>();

        // Create some sample Cart objects and add them to the cartItems list
        Cart cart1 = new Cart(1L, 1L, 2);
        Cart cart2 = new Cart(2L, 1L, 3);
        cartItems.add(cart1);
        cartItems.add(cart2);

        when(cartRepository.findByCustomerId(customerId)).thenReturn(cartItems);

        List<Cart> result = cartService.getCartByCustomerId(customerId);

        assertEquals(cartItems, result);
    }
}
