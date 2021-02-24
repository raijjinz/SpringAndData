package com.example.PostgreSpringDemo.service;

import com.example.PostgreSpringDemo.dto.DepartmentRequestDTO;
import com.example.PostgreSpringDemo.dto.DepartmentResponseDTO;

public interface DepartmentService {
     DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO);
}
