package com.example.PostgreSpringDemo.service;

import com.example.PostgreSpringDemo.dto.DepartmentRequestDTO;
import com.example.PostgreSpringDemo.dto.DepartmentResponseDTO;
import com.example.PostgreSpringDemo.entity.Department;

public interface DepartmentService {
     DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO);

     Department getDepartmentById(Long id);

     DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO departmentRequestDTO);
}
