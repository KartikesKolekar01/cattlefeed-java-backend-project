package com.example.cattlefeed.service;

import com.example.cattlefeed.model.User;
import com.example.cattlefeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Register a new user (With Validation)
    public User register(User user) {
        // १. ईमेल आधीपासून डेटाबेसमध्ये आहे का ते तपासा
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Error: हा ईमेल (" + user.getEmail() + ") आधीच वापरला गेला आहे!");
        }

        // २. पासवर्ड एनकोड करा
        user.setPassword(encoder.encode(user.getPassword()));

        // ३. युझर सेव्ह करा
        return userRepository.save(user);
    }

    // ✅ Login
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && encoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("ईमेल किंवा पासवर्ड चुकीचा आहे!");
    }

    // ✅ Change password
    public String changePassword(String email, String oldPassword, String newPassword) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!encoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("Old password is incorrect");
        }

        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);

        return "Password updated successfully";
    }

    // ✅ Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}