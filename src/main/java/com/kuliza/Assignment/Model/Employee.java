package com.kuliza.Assignment.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EmployeeDetails")
public class Employee extends BaseModel {

	@NotBlank
	private String name;

	private String age;

	private int salary;

	@Size(min = 10, max = 10)
	private String phone;

	public Employee() {
		super();
		this.setIsDeleted(false);
	}

	public Employee(@NotBlank String name, String age, int salary, @Size(min = 10, max = 10) String phone) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}