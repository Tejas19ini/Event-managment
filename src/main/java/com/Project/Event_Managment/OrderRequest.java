package com.Project.Event_Managment;

import java.time.LocalDate;

public class OrderRequest {

    private Long userId;
    private Long foodId;
    private int quantity;
    private LocalDate bookingDate;

    public Long getUserId() {
        return userId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}