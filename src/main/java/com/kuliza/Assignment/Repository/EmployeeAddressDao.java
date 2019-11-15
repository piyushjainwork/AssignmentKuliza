package com.kuliza.Assignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuliza.Assignment.Model.Employee;
import com.kuliza.Assignment.Model.EmployeeAddress;

@Repository
public interface EmployeeAddressDao extends JpaRepository<EmployeeAddress, Long> {

	public List<EmployeeAddress> findByEmployee(Employee employee);

}