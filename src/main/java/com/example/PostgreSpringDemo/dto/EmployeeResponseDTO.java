package com.example.PostgreSpringDemo.dto;

import com.example.PostgreSpringDemo.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private DepartmentResponseDTO department;
    //private String departmentName;

    public void setDepartmentFromEntity(Department departmentEntity){
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setId(departmentEntity.getId());
        departmentResponseDTO.setName(departmentEntity.getName());
        this.department = departmentResponseDTO;
    }

}
