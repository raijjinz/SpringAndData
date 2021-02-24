package com.example.PostgreSpringDemo.repository;

import com.example.PostgreSpringDemo.entity.Department;
import com.example.PostgreSpringDemo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    //by method name

    List<Employee> findByDepartment(Department department);

    List<Employee> findByDepartment_Id(Long departmentId);




    //by @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1") //? represents first parameter ie departmentiD of multiple parameters
    List<Employee> getEmployeeListByDepartmentId(Long departmentId);

    //by native Query
    @Query(value ="SELECT * FROM employee e WHERE e.department_id =?1",nativeQuery = true)
    List<Employee> getEmployeeListByNativeQuery(Long departmentId);
}
