package com.kuliza.Assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kuliza.Assignment.Repository.EmployeeDao;
import com.kuliza.Assignment.ServiceImpl.EmployeeServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	@InjectMocks
	private EmployeeServiceImplementation empService;

	@Mock
	private EmployeeDao empDao;

	@Test
	public void deleteByIdTest() {

		long fakeid = 15;
		assertEquals("User Not Found", empService.deleteEmployee(fakeid));

	}

}
