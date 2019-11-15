package com.kuliza.Assignment.Service;

import java.util.HashMap;
import java.util.List;

import com.kuliza.Assignment.Model.Employee;
import com.kuliza.Assignment.Pojo.EmployeePojo;

public interface EmpService {

	public String postEmpDetails(EmployeePojo empdetail);

	public List<Employee> getEmpDetails();

	public Employee getbyid(long empid);

	public Employee saveOrUpdate(EmployeePojo empdetail, long id);

	public String deleteEmployee(long empid);
	
	public List<HashMap<String, Object>> getAllUsers();

}
