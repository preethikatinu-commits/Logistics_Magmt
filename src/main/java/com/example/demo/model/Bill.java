package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Bill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Bill amount cannot be null")
    @Min(value = 1, message = "Bill amount must be at least 1")
    private Double amount;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    // Association with Employee
    @ManyToOne(fetch = FetchType.LAZY)  // Many bills → One employee
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    

    public Bill() {}
    
		public Bill(Long id,
			@NotNull(message = "Bill amount cannot be null") @Min(value = 1, message = "Bill amount must be at least 1") Double amount,
			@NotNull(message = "Date is required") LocalDate date,
			@Size(max = 255, message = "Description cannot exceed 255 characters") String description,
			Employee employee) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.employee = employee;
	}

		// --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

	@Override
	public String toString() {
		return "Bill [id=" + id + ", amount=" + amount + ", date=" + date + ", description=" + description
				+ ", employee=" + employee + "]";
	}

}
