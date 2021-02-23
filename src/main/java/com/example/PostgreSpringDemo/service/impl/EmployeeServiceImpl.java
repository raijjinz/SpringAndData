package com.example.PostgreSpringDemo.service.impl;

import com.example.PostgreSpringDemo.dto.EmployeeRequestDTO;
import com.example.PostgreSpringDemo.dto.EmployeeResponseDTO;
import com.example.PostgreSpringDemo.entity.Employee;
import com.example.PostgreSpringDemo.repository.EmployeeRepository;
import com.example.PostgreSpringDemo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        Employee employee = new Employee();
        BeanUtils.copyProperties(requestDTO, employee);
        Employee savedEmployee = employeeRepository.save(employee);
        BeanUtils.copyProperties(savedEmployee,responseDTO);
        return responseDTO;
    }

    public EmployeeResponseDTO getEmployeeById(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            //Copy from employee to responose dto
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employeeOptional.get(), employeeResponseDTO);

            return employeeResponseDTO;

        }

        return null;
    }

    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO requestDTO){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            //update employee
            Employee employeeFromDB =employeeOptional.get();
            employeeFromDB.setName(requestDTO.getName());
            employeeFromDB.setDepartmentName(requestDTO.getDepartmentName());

            //save to db
            Employee savedEmployee = employeeRepository.save(employeeFromDB);

            //copy from employee to response DTO

            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(savedEmployee, responseDTO);

            return responseDTO;



        }
        return null;
    }


    public EmployeeResponseDTO deleteEmployeeById(Long id){
        Optional<Employee> employeeOptional= employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employeeFromDB = employeeOptional.get();

            //delete
            employeeRepository.deleteById(id);
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employeeFromDB,responseDTO);
            return responseDTO;

        }

        return null;



    }
}
