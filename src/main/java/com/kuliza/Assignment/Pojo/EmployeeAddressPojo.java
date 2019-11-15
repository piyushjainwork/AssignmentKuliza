package com.kuliza.Assignment.Pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeAddressPojo {

	private long empid;

	@Size(min = 3)
	private String cityname;
	@Size(min = 6, max = 6)
	private String pincode;

	@Size(min = 3)
	private String streetname;

	@NotBlank
	private String statename;

	public EmployeeAddressPojo(long empid, @Size(min = 3) String cityname, @Size(min = 6, max = 6) String pincode,
			@Size(min = 3) String streetname, @NotBlank String statename) {
		super();
		this.empid = empid;
		this.cityname = cityname;
		this.pincode = pincode;
		this.streetname = streetname;
		this.statename = statename;

	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
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

}
