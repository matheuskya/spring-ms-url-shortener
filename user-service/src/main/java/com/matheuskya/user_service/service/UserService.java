package com.matheuskya.user_service.service;

import com.matheuskya.user_service.dto.UserRequestDto;
import com.matheuskya.user_service.dto.UserResponseDto;
import com.matheuskya.user_service.exceptions.ResourceNotFoundException;
import com.matheuskya.user_service.model.User;
import com.matheuskya.user_service.model.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public UserResponseDto createNewUser(UserRequestDto requestDto) {
        User newUser = new User();
        newUser.setName(requestDto.getName());
        newUser.setPassword(requestDto.getPassword());

        userRepository.save(newUser);

        return convertToDto(newUser);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public UserResponseDto updateUser(UserRequestDto updatedInfo, String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
        user.setPassword(updatedInfo.getPassword());
        user.setName(updatedInfo.getName());
        userRepository.save(user);

        return convertToDto(user);
    }

    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id:" +
                                id
                                +
                                " not found"));
        userRepository.delete(user);
    }

    private UserResponseDto convertToDto(User user) {
        UserResponseDto response = new UserResponseDto();
        response.setId(user.getId());
        response.setName(user.getName());
        return response;
    }
}
