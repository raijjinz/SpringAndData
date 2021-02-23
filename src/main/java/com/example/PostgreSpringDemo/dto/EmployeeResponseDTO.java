package com.example.PostgreSpringDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String departmentName;
}
