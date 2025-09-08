package com.example.demo.dto;

public class EmployeeBillSummaryDTO {

    private String employeeName;
    private int totalBillsToday;
    private double totalAmount;

    // --- Constructors ---
    public EmployeeBillSummaryDTO() {
    }

    public EmployeeBillSummaryDTO(String employeeName, int totalBillsToday, double totalAmount) {
        this.employeeName = employeeName;
        this.totalBillsToday = totalBillsToday;
        this.totalAmount = totalAmount;
    }

    // --- Getters & Setters ---
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public int getTotalBillsToday() { return totalBillsToday; }
    public void setTotalBillsToday(int totalBillsToday) { this.totalBillsToday = totalBillsToday; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    // --- toString() ---
    @Override
    public String toString() {
        return "EmployeeBillSummaryDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", totalBillsToday=" + totalBillsToday +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

