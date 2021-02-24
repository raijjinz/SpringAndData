package com.example.PostgreSpringDemo.service.impl;

import com.example.PostgreSpringDemo.dto.DepartmentRequestDTO;
import com.example.PostgreSpringDemo.dto.DepartmentResponseDTO;
import com.example.PostgreSpringDemo.entity.Department;
import com.example.PostgreSpringDemo.repository.DepartmentRepository;
import com.example.PostgreSpringDemo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO) {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        Department department = new Department();
        BeanUtils.copyProperties(requestDTO, department);
        Department savedDepartment = departmentRepository.save(department);
        BeanUtils.copyProperties(savedDepartment, departmentResponseDTO);
        return departmentResponseDTO;
    }
}
