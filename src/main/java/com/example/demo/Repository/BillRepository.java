package com.example.demo.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	
	@Query("SELECT COUNT(b) FROM Bill b WHERE b.employee.id = :empId AND b.date = :date")
    int countBillsByEmployeeAndDate(@Param("empId") Long empId, @Param("date") LocalDate date);

    // Sum total amount for employee on a given date
    @Query("SELECT COALESCE(SUM(b.amount), 0) FROM Bill b WHERE b.employee.id = :empId AND b.date = :date")
    double sumAmountByEmployeeAndDate(@Param("empId") Long empId, @Param("date") LocalDate date);


}
