package com.Project.Event_Managment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "foodss")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column(name = "food_name")   // ✅ FIX
    private String foodName;

    private String type;
    private Double price;

    // ✅ GETTERS
    public Long getFoodId() { return foodId; }
    public String getFoodName() { return foodName; }
    public String getType() { return type; }
    public Double getPrice() { return price; }

    // ✅ SETTERS
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public void setType(String type) { this.type = type; }
    public void setPrice(Double price) { this.price = price; }
}