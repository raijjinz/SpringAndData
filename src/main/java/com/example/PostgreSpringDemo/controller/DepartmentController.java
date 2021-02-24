package com.example.PostgreSpringDemo.controller;

import com.example.PostgreSpringDemo.dto.DepartmentRequestDTO;
import com.example.PostgreSpringDemo.dto.DepartmentResponseDTO;
import com.example.PostgreSpringDemo.entity.Department;
import com.example.PostgreSpringDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    //POST
    @PostMapping
    public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO requestDTO){
        return departmentService.createDepartment(requestDTO);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable ("id") Long departmentId, @RequestBody DepartmentRequestDTO departmentRequestDTO){
        return departmentService.updateDepartment(departmentId, departmentRequestDTO);
    }
}

