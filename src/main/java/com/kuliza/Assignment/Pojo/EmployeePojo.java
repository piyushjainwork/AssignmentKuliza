package com.kuliza.Assignment.Pojo;

import java.util.HashMap;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EmployeePojo {


	@NotBlank
	private String name;

	@NotBlank
	private String age;

	@Min(value = 3)
	private int salary;

	@NotBlank
	private String phone;

	public EmployeePojo(@NotBlank String name, @NotBlank String age, @Min(3) int salary, @NotBlank String phone) {
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
