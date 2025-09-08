package com.example.demo.util.mapper;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;


public class EmployeeMapper {

    // Entity → DTO
    public static EmployeeDTO toDTO(Employee e) {
        if (e == null) return null;
        return new EmployeeDTO(e.getId(), e.getName(), e.getRole());
    }

    // DTO → Entity
    public static Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;
        Employee emp = new Employee();
        emp.setId(dto.getId());  // optional if new entity
        emp.setName(dto.getName());
        emp.setRole(dto.getRole());
        return emp;
    }
}
