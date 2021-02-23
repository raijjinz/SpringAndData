package com.example.PostgreSpringDemo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class EmployeeRequestDTO {
    private Long id;
    private String name;
    private String departmentName;
}
