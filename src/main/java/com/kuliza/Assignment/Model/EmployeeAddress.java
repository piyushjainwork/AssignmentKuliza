package com.kuliza.Assignment.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EmployeeAddress")
public class EmployeeAddress extends BaseModel {

	@Size(min = 3)
	private String cityname;
	@Size(min = 6, max = 6)
	private String pincode;

	@Size(min = 3)
	private String streetname;

	@NotBlank
	private String statename;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EmployeeId")
	private Employee employee;

	public EmployeeAddress() {
		super();
		this.setIsDeleted(false);
	}

	public EmployeeAddress(@Size(min = 3) String cityname, @Size(min = 6, max = 6) String pincode,
			@Size(min = 3) String streetname, @NotBlank String statename, Employee employee) {
		super();
		this.setIsDeleted(false);
		this.cityname = cityname;
		this.pincode = pincode;
		this.streetname = streetname;
		this.statename = statename;
		this.employee = employee;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
