package com.matheuskya.user_service.dto;

public class UserResponseDto {
    private String id;
    private String name;

    public UserResponseDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserResponseDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
