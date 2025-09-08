package com.example.demo.service;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.BillRepository;
import com.example.demo.dto.EmployeeBillSummaryDTO;
import com.example.demo.model.Employee;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final EmployeeService employeeService;

    public BillService(BillRepository billRepository, EmployeeService employeeService) {
        this.billRepository = billRepository;
        this.employeeService = employeeService;
    }

    public EmployeeBillSummaryDTO getBillsSummaryToday(Long empId) {
        Employee emp = employeeService.getEmployeeById(empId); // validation

        int totalBills = billRepository.countBillsByEmployeeAndDate(empId, LocalDate.now());
        double totalAmount = billRepository.sumAmountByEmployeeAndDate(empId, LocalDate.now());

        return new EmployeeBillSummaryDTO(emp.getName(), totalBills, totalAmount);
    }
}

