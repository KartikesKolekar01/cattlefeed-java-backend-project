package com.example.cattlefeed.controller;
import com.example.cattlefeed.dto.ChangePasswordRequest;
import com.example.cattlefeed.model.User;
import com.example.cattlefeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordRequest request){
        return userService.changePassword(
                request.getEmail(),
                request.getOldPassword(),
                request.getNewPassword()
        );
    }
}