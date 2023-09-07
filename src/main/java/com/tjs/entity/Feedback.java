package com.tjs.entity;

import javax.persistence.*;
import java.util.Date;
//Imports (assuming you already have them)

@Entity
@Table(name = "feedback")
public class Feedback {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "name", nullable = false)
 private String name;

 @Column(name = "email", nullable = false)
 private String email;

 @Column(name = "message", nullable = false, columnDefinition = "TEXT")
 private String message;

 @Column(name = "entry_date", nullable = false)
 @Temporal(TemporalType.TIMESTAMP)
 private Date entryDate;

 // Constructors
 public Feedback() {
     // Default constructor
 }

 public Feedback(String name, String email, String message) {
     this.name = name;
     this.email = email;
     this.message = message;
     this.entryDate = new Date();
 }

 // Getters and setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getMessage() {
     return message;
 }

 public void setMessage(String message) {
     this.message = message;
 }

 public Date getEntryDate() {
     return entryDate;
 }

 public void setEntryDate(Date entryDate) {
     this.entryDate = entryDate;
 }
 
 // You can add other methods as needed
 @Override
 public String toString() {
     return "Feedback{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", email='" + email + '\'' +
             ", message='" + message + '\'' +
             ", entryDate=" + entryDate +
             '}';
 }

}
