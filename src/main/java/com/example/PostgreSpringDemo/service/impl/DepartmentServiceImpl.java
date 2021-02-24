package com.example.PostgreSpringDemo.service.impl;

import com.example.PostgreSpringDemo.dto.DepartmentRequestDTO;
import com.example.PostgreSpringDemo.dto.DepartmentResponseDTO;
import com.example.PostgreSpringDemo.entity.Department;
import com.example.PostgreSpringDemo.entity.Employee;
import com.example.PostgreSpringDemo.repository.DepartmentRepository;
import com.example.PostgreSpringDemo.repository.EmployeeRepository;
import com.example.PostgreSpringDemo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO) {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        Department department = new Department();
        BeanUtils.copyProperties(requestDTO, department);
        Department savedDepartment = departmentRepository.save(department);
        BeanUtils.copyProperties(savedDepartment, departmentResponseDTO);
        return departmentResponseDTO;
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    @Transactional // either all statements get executed or none
    public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO departmentRequestDTO){
        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRepository.findByDepartment_Id(departmentId);

        //update dept
        department.setName(departmentRequestDTO.getName());
        Department savedDepartment = departmentRepository.save(department);

        //append department code to employee code

        employeeList.forEach(employee -> {
            employee.setCode(departmentRequestDTO.getDepartmentCode());
        });
        employeeRepository.saveAll(employeeList);



        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(savedDepartment, departmentResponseDTO);
        return  departmentResponseDTO;
    }
}
