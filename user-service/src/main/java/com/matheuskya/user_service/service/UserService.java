package com.matheuskya.user_service.service;

import com.matheuskya.user_service.dto.UserResponseDto;
import com.matheuskya.user_service.exceptions.ResourceNotFoundException;
import com.matheuskya.user_service.model.User;
import com.matheuskya.user_service.model.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto findUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id: " + id + " not found"
                ));
        return convertToDto(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private UserResponseDto convertToDto(User user) {
        UserResponseDto response = new UserResponseDto();
        response.setId(user.getId());
        response.setName(user.getName());
        return response;
    }
}
