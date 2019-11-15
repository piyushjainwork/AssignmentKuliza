package com.kuliza.Assignment.Controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuliza.Assignment.Model.Employee;
import com.kuliza.Assignment.Pojo.EmployeePojo;
import com.kuliza.Assignment.Service.EmpService;
import com.kuliza.Assignment.ServiceImpl.EmployeeServiceImplementation;

@RestController
public class EmployeeController {

	@Autowired
	EmpService empservice;

	@PostMapping("/postemployee")
	public String postEmpDetails(@Valid @RequestBody EmployeePojo empdetails) {

		return empservice.postEmpDetails(empdetails);
	}

	@PutMapping("/updateemp/{id}")
	public Employee saveOrUpdate(@PathVariable long id, @Valid @RequestBody EmployeePojo empdetails) {
		return empservice.saveOrUpdate(empdetails, id);
	}

	@GetMapping("/getempdetail")
	public List<Employee> getEmpDetails() {
		return empservice.getEmpDetails();
	}

	@GetMapping("/getemp/{id}")
	public Employee getEmpbyid(@PathVariable long id) {

		return empservice.getbyid(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
		return empservice.deleteEmployee(id);
	}
	
	@GetMapping("/getalluser")
	public List<HashMap<String,Object>> getAll()
	{
		return empservice.getAllUsers();
	}

}