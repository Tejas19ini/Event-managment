package com.Project.Event_Managment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final FoodBookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final FoodRepository foodRepo;

    public OrderController(FoodBookingRepository b,
                           UserRepository u,
                           FoodRepository f) {
        this.bookingRepo = b;
        this.userRepo = u;
        this.foodRepo = f;
    }

 @PostMapping
public FoodBooking createOrder(@RequestBody OrderRequest request) {

    // ✅ Correct way to fetch user
    User user = userRepo.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

    // ✅ Correct way to fetch food
    Food food = foodRepo.findById(request.getFoodId())
            .orElseThrow(() -> new RuntimeException("Food not found"));

    // ✅ Create booking
    FoodBooking booking = new FoodBooking();
    booking.setUser(user);
    booking.setFood(food);
    booking.setQuantity(request.getQuantity());
    booking.setBookingDate(request.getBookingDate());
    booking.setStatus("PENDING");

    // ✅ Save using repository
    return bookingRepo.save(booking);
}

    @GetMapping
    public List<FoodBooking> getAllOrders() {
        return bookingRepo.findAll();
    }
}