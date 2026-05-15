package com.Project.Event_Managment;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "food_bookingss") 
public class FoodBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private int quantity;
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private String status = "PENDING";

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ✅ GETTERS
    public Long getBookingId() { return bookingId; }
    public int getQuantity() { return quantity; }
    public LocalDate getBookingDate() { return bookingDate; }
    public User getUser() { return user; }
    public Food getFood() { return food; }

    // ✅ SETTERS
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
    public void setUser(User user) { this.user = user; }
    public void setFood(Food food) { this.food = food; }
}