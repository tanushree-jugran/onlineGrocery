package com.tjs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tjs.entity.Order;
import com.tjs.repository.OrderRepository;
import com.tjs.service.OrderService; // Import the OrderService class

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderService orderService; // Autowire the OrderService

    @GetMapping("/{order_id}/status")
    public ResponseEntity<String> getOrderStatus(@PathVariable("order_id") Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findByOrderId(orderId);

        if (optionalOrder.isPresent()) {
            // You can retrieve the order status from the order object and return it
            Order order = optionalOrder.get();
            String status = "Your order with ID " + orderId + " is being processed.";
            return ResponseEntity.ok(status);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customers/{customer_id}/orders")
    public ResponseEntity<List<Order>> getAllOrdersByCustomer(@PathVariable("customer_id") Long customerId) {
        List<Order> allOrdersByCustomer = orderRepository.findByCustomerId(customerId);

        if (!allOrdersByCustomer.isEmpty()) {
            return ResponseEntity.ok(allOrdersByCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Save the new order to the database using the OrderService
        Order savedOrder = orderService.createOrder(order);

        // Return a response with the saved order and HTTP status code 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
