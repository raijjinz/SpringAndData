package com.example.PostgreSpringDemo.dto;

import lombok.Data;

@Data
public class DepartmentRequestDTO {
    private Long id;
    private String name;
    private String departmentCode;
}
