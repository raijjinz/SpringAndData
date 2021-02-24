package com.example.PostgreSpringDemo.repository;

import com.example.PostgreSpringDemo.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository  extends CrudRepository<Department, Long> {
}
