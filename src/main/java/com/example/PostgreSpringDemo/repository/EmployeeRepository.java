package com.example.PostgreSpringDemo.repository;

import com.example.PostgreSpringDemo.entity.Department;
import com.example.PostgreSpringDemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    //by method name

    List<Employee> findByDepartment(Department department);

    //do impl

    //by @Query annotation

    //by native Query
}
