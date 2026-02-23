package com.example.cattlefeed.service;

import com.example.cattlefeed.model.User;
import com.example.cattlefeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user!=null && encoder.matches(password,user.getPassword())){
            return user;
        }
        return null;
    }

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
}