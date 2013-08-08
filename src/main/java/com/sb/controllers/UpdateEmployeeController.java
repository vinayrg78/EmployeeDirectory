package com.sb.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sb.domain.Employee;
import com.sb.repositories.EmployeeRepository;


@Controller
@RequestMapping(value="/rest/updateEmployees")
public class UpdateEmployeeController{

	@Autowired
	EmployeeRepository employeeRepository;


	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void update(@RequestBody Employee employee) {
        employeeRepository.updateEmployee(employee);
    }
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
}

