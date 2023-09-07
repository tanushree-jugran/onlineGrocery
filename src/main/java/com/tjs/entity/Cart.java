package com.tjs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




	@Entity
	@Table(name = "cart")
	public class Cart {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	    private Long id;

	    @Column(name = "customer_id")
	    private Long customerId;

	    @Column(name = "product_id")
	    private Long productId;

	    private int quantity;

	    public Cart() {
	    }

	    public Cart(Long customerId, Long productId, int quantity) {
	        this.customerId = customerId;
	        this.productId = productId;
	        this.quantity = quantity;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(Long customerId) {
	        this.customerId = customerId;
	    }

	    public Long getProductId() {
	        return productId;
	    }

	    public void setProductId(Long productId) {
	        this.productId = productId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    @Override
	    public String toString() {
	        return "Cart{" +
	                "id=" + id +
	                ", customerId=" + customerId +
	                ", productId=" + productId +
	                ", quantity=" + quantity +
	                '}';
	    }
	}
