package com.kuliza.Assignment.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliza.Assignment.Model.Employee;
import com.kuliza.Assignment.Model.EmployeeAddress;
import com.kuliza.Assignment.Pojo.EmployeeAddressPojo;
import com.kuliza.Assignment.Repository.EmployeeAddressDao;
import com.kuliza.Assignment.Repository.EmployeeDao;

@Service
public class EmployeeAddressService {
	@Autowired
	EmployeeAddressDao empaddrepo;

	@Autowired
	EmployeeDao emprepo;

	public void postEmpAddress(EmployeeAddressPojo empaddress) {
		long empid = empaddress.getEmpid();

		Employee obj = emprepo.findById(empid);

		if (obj != null) {
			EmployeeAddress empaddobj = new EmployeeAddress();

			empaddobj.setCityname(empaddress.getCityname());
			empaddobj.setPincode(empaddress.getPincode());
			empaddobj.setStatename(empaddress.getStatename());
			empaddobj.setStreetname(empaddress.getStreetname());
			empaddobj.setEmployee(obj);
			empaddrepo.save(empaddobj);
		}
	}
	
	//

	

	public List<EmployeeAddress> getAllAddress() {
		return empaddrepo.findAll();
	}

	public List<HashMap<String, String>> getAddressEmp(long id) {
		Employee empobj = emprepo.findById(id);

		List<EmployeeAddress> emplist = empaddrepo.findByEmployee(empobj);

		List<HashMap<String, String>> l1 = new ArrayList<>();

		for (int i = 0; i < emplist.size(); i++) {
			EmployeeAddress eobj = emplist.get(i);

			HashMap<String, String> h1 = new HashMap<>();

			h1.put("cityname", eobj.getCityname());
			h1.put("pincode", eobj.getPincode());
			h1.put("statename", eobj.getStatename());
			h1.put("streetname", eobj.getStreetname());

			l1.add(h1);
		}
		return l1;
	}

	public String deleteByAddressId(long id) {
		Optional<EmployeeAddress> add = empaddrepo.findById(id);

		if (add != null) {
			empaddrepo.deleteById(id);
			return "address deleted";
		} else {
			return "Address do not exist";
		}
	}
}