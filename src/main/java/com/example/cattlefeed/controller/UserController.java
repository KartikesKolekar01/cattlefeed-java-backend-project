package com.example.cattlefeed.controller;

import com.example.cattlefeed.model.User;
import com.example.cattlefeed.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ Register
    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
        return userService.register(user);
    }

    // ✅ Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    // ✅ Change Password
    @PutMapping("/change-password")
    public String changePassword(@RequestBody PasswordChangeRequest request) {
        return userService.changePassword(
                request.getEmail(),
                request.getOldPassword(),
                request.getNewPassword()
        );
    }

    // ✅ Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // DTO for password change
    public static class PasswordChangeRequest {
        private String email;
        private String oldPassword;
        private String newPassword;

        // Getters and Setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getOldPassword() { return oldPassword; }
        public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

        public String getNewPassword() { return newPassword; }
        public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
    }
}