package com.matheuskya.user_service.controller;

import com.matheuskya.user_service.model.User;
import com.matheuskya.user_service.model.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository user){
        this.userRepository = user;
    }

    @GetMapping("/user")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
