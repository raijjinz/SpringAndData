package com.example.PostgreSpringDemo.repository;

import com.example.PostgreSpringDemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
