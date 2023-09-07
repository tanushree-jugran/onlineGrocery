package com.tjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tjs.entity.Customer;
import com.tjs.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        // You can validate and save the customer including the password here
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> loginCustomer(@RequestParam String email, @RequestParam String password) {
        // Implement the login logic here
        Optional<Customer> customer = customerService.loginCustomer(email, password);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    // Other methods like updating customer password, deleting customer, etc.
}
