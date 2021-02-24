package com.example.PostgreSpringDemo.service;

import com.example.PostgreSpringDemo.dto.EmployeeRequestDTO;
import com.example.PostgreSpringDemo.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
     EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);


     EmployeeResponseDTO getEmployeeById(Long id);

     EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO requestDTO);

     EmployeeResponseDTO deleteEmployeeById(Long id);

     List<EmployeeResponseDTO> getEmployeeListByDepartment(Long DepartmentId);
}
