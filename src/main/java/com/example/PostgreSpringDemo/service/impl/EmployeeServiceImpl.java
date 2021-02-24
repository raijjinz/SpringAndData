package com.example.PostgreSpringDemo.service.impl;

import com.example.PostgreSpringDemo.dto.DepartmentResponseDTO;
import com.example.PostgreSpringDemo.dto.EmployeeRequestDTO;
import com.example.PostgreSpringDemo.dto.EmployeeResponseDTO;
import com.example.PostgreSpringDemo.entity.Department;
import com.example.PostgreSpringDemo.entity.Employee;
import com.example.PostgreSpringDemo.repository.DepartmentRepository;
import com.example.PostgreSpringDemo.repository.EmployeeRepository;
import com.example.PostgreSpringDemo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO){

        Optional<Department> departmentOptional = departmentRepository.findById(requestDTO.getDepartment().getId());


        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        Employee employee = new Employee();


        if (departmentOptional.isPresent()){
            employee.setDepartment(departmentOptional.get());
        }
        else{
            Department department = new Department();
            department.setName(requestDTO.getDepartment().getName());
            employee.setDepartment(department);
        }
        BeanUtils.copyProperties(requestDTO, employee);
        Employee savedEmployee = employeeRepository.save(employee);
        BeanUtils.copyProperties(savedEmployee,responseDTO);


        responseDTO.setDepartmentFromEntity(savedEmployee.getDepartment());
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


            //fetch department from db
            Optional<Department> departmentOptional = departmentRepository.findById(requestDTO.getDepartment().getId());
            if (departmentOptional.isPresent()){
                employeeFromDB.setDepartment(departmentOptional.get());
            }
            else{
                Department department = new Department();
                department.setName(requestDTO.getDepartment().getName());
                employeeFromDB.setDepartment(department);
            }



            //save to db
            Employee savedEmployee = employeeRepository.save(employeeFromDB);

            //copy from employee to response DTO

            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(savedEmployee, responseDTO);

            responseDTO.setDepartmentFromEntity(savedEmployee.getDepartment());

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


    public List<EmployeeResponseDTO> getEmployeeListByDepartment(Long departmentId){
        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRepository.findByDepartment((department));
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
        for(Employee employee:employeeList){
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employee,responseDTO);
            responseDTO.setDepartmentFromEntity(employee.getDepartment());
            employeeResponseDTOList.add(responseDTO);
        }
        return employeeResponseDTOList;
    }
}
