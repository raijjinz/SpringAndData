package com.example.PostgreSpringDemo.controller;


import com.example.PostgreSpringDemo.dto.EmployeeRequestDTO;
import com.example.PostgreSpringDemo.dto.EmployeeResponseDTO;
import com.example.PostgreSpringDemo.service.EmployeeService;
import com.example.PostgreSpringDemo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //POST - /employee
    @PostMapping
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO requestDTO){
        return employeeService.createEmployee(requestDTO);

    }

    //GET - /employee/{id}

    @GetMapping("department/{id}")
    public List<EmployeeResponseDTO> getEmployeeById(@PathVariable ("id") Long departmentId){
        return employeeService.getEmployeeListByDepartment(departmentId);
    }

    //PUT - /employee/{id}
    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployeeById(@PathVariable  Long id, @RequestBody  EmployeeRequestDTO requestDTO){
        return employeeService.updateEmployeeById(id, requestDTO);
    }

    //DELETE - /employee/{id}
    @DeleteMapping("/{id}")
    public EmployeeResponseDTO deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);

    }


}
