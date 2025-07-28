package com.matheuskya.user_service.controller;

import com.matheuskya.user_service.dto.UserRequestDto;
import com.matheuskya.user_service.dto.UserResponseDto;
import com.matheuskya.user_service.model.User;
import com.matheuskya.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/user")
    public List<User> getAll() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserResponseDto getById(@PathVariable String id) {
        UserResponseDto response = userService.findUserById(id);
        return response;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createNewUser(
            @RequestBody UserRequestDto userRequestDto
    ) {
        UserResponseDto newUser = userService.createNewUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto updatedInfo,
                                                      @PathVariable String id) {
        UserResponseDto updatedUser = userService.updateUser(updatedInfo, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
