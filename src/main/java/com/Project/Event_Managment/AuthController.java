package com.Project.Event_Managment;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // 🔐 LOGIN
    @PostMapping("/login")
public Map<String, Object> login(@RequestBody Map<String, String> data) {

    String email = data.get("email");
    String password = data.get("password");

    Optional<User> user = userRepository.findByEmail(email);

    if (user.isPresent() && user.get().getPassword().equals(password)) {
        User foundUser = user.get();

        return Map.of(
            "status", "success",
            "userId", foundUser.getUserId(),
            "role", foundUser.getRole()
        );

    } else {
        return Map.of("status", "error");
    }
}

    // 🆕 SIGNUP
@PostMapping("/signup")
public Map<String, String> signup(@RequestBody Map<String, Object> data) {

    String name = (String) data.get("name");
    String email = (String) data.get("email");
    String password = (String) data.get("password");
    String role = (String) data.get("role");
    String adminKey = (String) data.get("adminKey");

    // Check existing user
    Optional<User> existingUser = userRepository.findByEmail(email);
    if (existingUser.isPresent()) {
        return Map.of("status", "fail", "message", "User already exists");
    }

    User user = new User();
    user.setName(name);
    user.setEmail(email);
    user.setPassword(password);

    // 🔐 Admin verification
    if ("ADMIN".equals(role)) {

        if (!"SECRET123".equals(adminKey)) {
            return Map.of("status", "fail", "message", "Invalid Admin Key");
        }

        user.setRole("ADMIN");

    } else {
        user.setRole("USER");
    }

    userRepository.save(user);

    return Map.of("status", "success");
}
}