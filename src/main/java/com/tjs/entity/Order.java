package com.tjs.entity;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    // Constructors, getters, setters, and other methods

    public Order() {
    }

    public Order(Long customerId, Date orderDate, String deliveryAddress, String paymentMethod, BigDecimal totalAmount) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }

    // Getters and setters for other fields

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
