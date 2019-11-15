package com.kuliza.Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuliza.Assignment.Model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	Employee findById(long id);

}
