package com.example.demo.controller;

import com.example.demo.dto.EmployeeBillSummaryDTO;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/employees")
public class EmployeeWebController {

    private final EmployeeService employeeService;
    private final BillService billService;

    public EmployeeWebController(EmployeeService employeeService, BillService billService) {
        this.employeeService = employeeService;
        this.billService = billService;
    }

    // ✅ Show all employees in JSP
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees"; // → employees.jsp
    }

    // ✅ Show today's bill summary for selected employee
    @GetMapping("/{id}/bills/today")
    public String employeeBillsToday(@PathVariable Long id, Model model) {
        EmployeeBillSummaryDTO summary = billService.getBillsSummaryToday(id);
        model.addAttribute("summary", summary);
        return "employeeBills"; // → employeeBills.jsp
    }
}

