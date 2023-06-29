package com.example.userservice;

import lombok.Data;

@Data
public class ResponseDto {
    private DepartmentDto department;
    private UserDto user;
}
