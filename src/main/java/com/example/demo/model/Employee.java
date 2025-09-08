package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    private String department;

    @NotBlank(message = "Role is required")
    private String role;

    // Association: One Employee → Many Bills
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bill> bills = new ArrayList<>();

    // --- Constructors ---
    public Employee() {
        // Default constructor required by JPA
    }

    public Employee(String name, String department, String role) {
        this.name = name;
        this.department = department;
        this.role = role;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<Bill> getBills() { return bills; }
    public void setBills(List<Bill> bills) { this.bills = bills; }

    // Helper method to add a Bill to Employee
    public void addBill(Bill bill) {
        bills.add(bill);
        bill.setEmployee(this); // maintain bidirectional association
    }

    // Helper method to remove a Bill from Employee
    public void removeBill(Bill bill) {
        bills.remove(bill);
        bill.setEmployee(null);
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", billsCount=" + (bills != null ? bills.size() : 0) +
                '}';
    }
}
