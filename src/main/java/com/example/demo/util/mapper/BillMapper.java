package com.example.demo.util.mapper;



import com.example.demo.dto.EmployeeBillSummaryDTO;
import com.example.demo.model.Bill;



public class BillMapper {

    // Bill Entity → Bill Summary DTO
    public static EmployeeBillSummaryDTO toSummaryDTO(Bill bill) {
        if (bill == null) return null;

        return new EmployeeBillSummaryDTO(
                bill.getEmployee() != null ? bill.getEmployee().getName() : null,
                1, // since single bill = 1
                bill.getAmount()
        );
    }

    // For Aggregated Data (Employee + total counts + sum)
    public static EmployeeBillSummaryDTO toSummaryDTO(String employeeName, int totalBills, double totalAmount) {
        return new EmployeeBillSummaryDTO(employeeName, totalBills, totalAmount);
    }
}

