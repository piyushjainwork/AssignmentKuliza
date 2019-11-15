package com.kuliza.Assignment.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliza.Assignment.Model.Employee;
import com.kuliza.Assignment.Model.EmployeeAddress;
import com.kuliza.Assignment.Pojo.EmployeePojo;
import com.kuliza.Assignment.Repository.EmployeeAddressDao;
import com.kuliza.Assignment.Repository.EmployeeDao;
import com.kuliza.Assignment.Service.EmpService;

@Service
public class EmployeeServiceImplementation implements EmpService {

	private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImplementation.class);

	@Autowired
	EmployeeDao empRepo;
	
	@Autowired
	EmployeeAddressDao empaddrepo;

	public String postEmpDetails(EmployeePojo empdetail) {

		logger.debug("Entering to create a employee");
		Employee emp = new Employee();

		emp.setName(empdetail.getName());
		emp.setPhone(empdetail.getPhone());
		emp.setSalary(empdetail.getSalary());
		emp.setAge(empdetail.getAge());

		empRepo.save(emp);
		logger.debug("Employee Details Posted now exiting from post employee");

		return "Employee details poseted";
	}

	public List<Employee> getEmpDetails() {

		return empRepo.findAll();
	}

	
	
	public Employee getbyid(long empid) {
		logger.debug("Entering to get a employee by emp id");

		Employee emp = empRepo.findById(empid);
		if (emp == null) {
			return null;
		}
		logger.debug("completing  get a employee by emp id");
		return empRepo.findById(empid);
		
		

	}

	public Employee saveOrUpdate(EmployeePojo empdetail, long id) {
		logger.debug("Entering to save Or update employee ");

		Employee emp = empRepo.findById(id);

		System.out.println("Piyush");

		if (emp != null) {
			emp.setAge(empdetail.getAge());
			emp.setName(empdetail.getName());
			emp.setPhone(empdetail.getPhone());
			emp.setSalary(empdetail.getSalary());
			empRepo.save(emp);
			logger.debug("Completed  Updating a employee");
			return emp;
		} else {
			return null;
		}

	}

	public String deleteEmployee(long id) {
		logger.debug("Entering to delete a employee details ");

		Employee emp = empRepo.findById(id);

		if (emp != null) {
			empRepo.deleteById(id);
			logger.debug("Completed deleting a employee");
			return "user Deleted";
		}

		else {

			logger.debug("Employee do not exist");
			return "User Not Found";
		}

	}
	public List<HashMap<String, Object>> getAllUsers() {
		List<HashMap<String, Object>> users = new ArrayList<HashMap<String, Object>>();
		
		
		List<Employee> l1= empRepo.findAll();
		
		
		
		for(int i=0;i<l1.size();i++)
		{
			Employee e= l1.get(i);
			
			List<EmployeeAddress> l2= empaddrepo.findByEmployee(e);
			
			HashMap<String,Object> h1= new HashMap<>();
			h1.put("Id", e.getId());
			h1.put("Name",e.getName());
			h1.put("Age", e.getAge());
			h1.put("Phone", e.getPhone());
			h1.put("Salary", e.getSalary());
			h1.put("Address", l2);	
			users.add(h1);
	
		}
		return users;
	
//		for(Employee emp: l1) {
//			
//			List<EmployeeAddress> l2= empaddrepo.findByEmployee(emp);
//			
//			
//			HashMap<String,Object> h1= new HashMap<>();
//			
//			h1.put("name", emp.getName());
//			h1.put("address",l2);
////			for(int j=0;j<l2.size();j++)
////			{
////			h1.put("address",l2.get(j));
////			}
//			users.add(h1);
//			
//		}
//		return users;	
		
	}

}