package com.sb.controllers;


import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sb.domain.Employee;
import com.sb.repositories.EmployeeRepository;


@Controller
@RequestMapping(value="/rest/loadEmployees")
public class LoadEmployeesController{

	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String handleRequestInternal() {
        Gson gson = new Gson();
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        Type typeOfSrc = new TypeToken<List<Employee>>(){}.getType();
        String jsonString = gson.toJson(employeeList, typeOfSrc);
        return jsonString;
    }

	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody Employee employee) {
        employeeRepository.insertEmployee(employee);
    }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody Employee delete(@PathVariable("id") String id) {
        return employeeRepository.deleteEmployee(id);
    }
	
	
//	private List<Employee> getEmployeeList() {
//		List<Employee> eList = new ArrayList<Employee>();
//		eList.add(new Employee(1, "Mark Wahlberg", "IJ-I", "Thou shall not steal!"));
//		eList.add(new Employee(2, "Vinay Gangoli", "PRO-CTCAE", "Dont fix what ain't broke!"));
//		eList.add(new Employee(3, "Saurabh Agarwal", "CGW", "If it ain't tested, it ain't fixed!"));
//		eList.add(new Employee(4, "Monish Dombla", "CTRP", "You can fix anything with the right Hammer!"));
//		eList.add(new Employee(5, "Ramakrishna Gundala", "C3PR", "If you dont fix it, I will!"));
//		eList.add(new Employee(6, "Kumar Sambhuni", "CaAERS", "Mr. Problem Solver!"));
//		
//		return eList;
//	}

}

