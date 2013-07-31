package com.sb.repositories;

import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sb.domain.Employee;

public class TestEmployeeRepository extends TestCase {

	ConfigurableApplicationContext applicationContext;
	EmployeeRepository employeeRepository;
	
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("com/sb/applicationContext.xml");
		employeeRepository = (EmployeeRepository) applicationContext.getBean("employeeRepository");
	}

	@After
	public void tearDown() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testInsertEmployee() {
		Employee employee = new Employee("Testing Insert", "TEST", "I fix code!");
		employeeRepository.insertEmployee(employee);
		List<Employee> eList = employeeRepository.findEmployeeByName(employee.getName());
		
		assertEquals(eList.size(), 1);
		assertEquals(eList.get(0).getName(), employee.getName());
		assertEquals(eList.get(0).getProject(), employee.getProject());
		assertEquals(eList.get(0).getMotto(), employee.getMotto());
		
		employeeRepository.deleteEmployee(employee.getId());
	}

	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee("Testing Delete", "DELME", "I delete code!");
		employeeRepository.insertEmployee(employee);
		
		List<Employee> eList = employeeRepository.findEmployeeByName(employee.getName());
		assertEquals(1, eList.size());
		
		employeeRepository.deleteEmployee(employee.getId());	
		
		eList = employeeRepository.findEmployeeByName(employee.getName());
		assertEquals(0, eList.size());
	}

	@Test
	public void testGetAllEmployees() {
		employeeRepository.insertEmployee(new Employee("Testing All 1", "ALL", "I delete code!"));
		employeeRepository.insertEmployee(new Employee("Testing All 2", "ALL", "I delete code!"));
		employeeRepository.insertEmployee(new Employee("Testing All 3", "ALL", "I delete code!"));
		
		List<Employee> eList = employeeRepository.getAllEmployees();
		assertEquals(3, eList.size());

		for(int index = 0 ; index < eList.size(); index++){
			employeeRepository.deleteEmployee(eList.get(index).getId());	
		}
	}

}
