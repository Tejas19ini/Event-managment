package com.Project.Event_Managment;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "*")
public class FoodController {

    private final FoodRepository foodRepo;

    public FoodController(FoodRepository foodRepo) {
        this.foodRepo = foodRepo;
    }

    // ✅ USER: VIEW FOOD MENU
    @GetMapping
    public List<Food> getAllFoods() {
        return foodRepo.findAll();
    }

    // ✅ ADMIN: ADD FOOD
    @PostMapping("/admin/add")
    public Food addFood(@RequestBody Food food) {
        return foodRepo.save(food);
    }

    // ✅ ADMIN: DELETE FOOD
    @DeleteMapping("/admin/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodRepo.deleteById(id);
        return "Food Deleted";
    }
}