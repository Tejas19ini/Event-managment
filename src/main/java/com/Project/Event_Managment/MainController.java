package com.Project.Event_Managment;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MainController {

    private final UserRepository userRepo;
    private final CollegeRepository collegeRepo;
    private final EventRepository eventRepo;
    private final RegistrationRepository registrationRepo;
    private final FoodBookingRepository foodBookingRepository;
    private final FoodRepository foodRepo;

    public MainController(UserRepository u, CollegeRepository c, EventRepository e,
                          RegistrationRepository r, FoodBookingRepository f,
                          FoodRepository foodRepo) {
        this.userRepo = u;
        this.collegeRepo = c;
        this.eventRepo = e;
        this.registrationRepo = r;
        this.foodBookingRepository = f;
        this.foodRepo = foodRepo;
    }

    // ✅ EVENTS FOR USER
    @GetMapping("/user/events")
    public List<Event> getEvents() {
        return eventRepo.findAll();
    }

    // ✅ GET COLLEGES
    @GetMapping("/colleges")
    public List<College> getColleges() {
        return collegeRepo.findAll();
    }

    // ✅ GET USERS (ADMIN)
    @GetMapping("/admin/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // ✅ GET USER REGISTRATIONS
    @GetMapping("/registrationss/user/{id}")
    public List<Registration> getRegistrations(@PathVariable Long id) {
        return registrationRepo.findByUser_UserId(id);
    }

    @PostMapping("/registrationss")
public Registration registerEvent(@RequestBody Registration registration) {
    return registrationRepo.save(registration);
}

    // ✅ ADD EVENT
    @PostMapping("/admin/add-event")
    public Event addEvent(@RequestBody Event event) {
        return eventRepo.save(event);
    }

    // ✅ DELETE EVENT
    @DeleteMapping("/admin/delete-event/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepo.deleteById(id);
        return "Deleted";
    }

    // ✅ GET FOOD MENU
    @GetMapping("/food")
    public List<Food> getAllFood() {
        return foodRepo.findAll();
    }

    // ✅ ADD FOOD
    @PostMapping("/food")
    public Food addFood(@RequestBody Food food) {
        return foodRepo.save(food);
    }

    // ✅ DELETE FOOD
    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodRepo.deleteById(id);
        return "Food Deleted";
    }
}