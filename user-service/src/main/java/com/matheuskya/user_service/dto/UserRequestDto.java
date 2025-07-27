package com.matheuskya.user_service.dto;

public class UserRequestDto {
    private String name;
    private String password;

    public UserRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
