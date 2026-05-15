package com.Project.Event_Managment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpController {

    Map<String, String> otpStore = new HashMap<>();

    @PostMapping("/send-otp")
    public Map<String, String> sendOtp(@RequestBody Map<String, String> req) {

        String phone = req.get("phone");

        String otp = String.valueOf((int)(Math.random() * 9000) + 1000);

        otpStore.put(phone, otp);

        System.out.println("OTP for " + phone + " is: " + otp);

        return Map.of("message", "OTP sent");
    }

    @PostMapping("/verify-otp")
    public Map<String, Object> verifyOtp(@RequestBody Map<String, String> req) {

        String phone = req.get("phone");
        String otp = req.get("otp");

        String savedOtp = otpStore.get(phone);

        boolean success = savedOtp != null && savedOtp.equals(otp);

        if (success) {
            otpStore.remove(phone); // important
        }

        return Map.of(
            "success", success,
            "message", success ? "OTP Verified" : "Invalid OTP"
        );
    }
}