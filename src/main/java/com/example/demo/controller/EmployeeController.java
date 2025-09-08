package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeBillSummaryDTO;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.BillService;
import com.example.demo.util.mapper.EmployeeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final BillService billService;

    public EmployeeController(EmployeeService employeeService, BillService billService) {
        this.employeeService = employeeService;
        this.billService = billService;
    }

    // ✅ Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    // ✅ Get bill summary for today by employee
    @GetMapping("/{id}/bills/today")
    public ResponseEntity<EmployeeBillSummaryDTO> getBillsToday(@PathVariable Long id) {
        return ResponseEntity.ok(billService.getBillsSummaryToday(id));
    }
}
