package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entity.Employee;
import com.yash.service.EmployeeService;

import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/addEmployeeData")
	public Employee addEmployeeData(@RequestBody Employee employee) {
		
		return employeeService.saveEmployeeObject(employee);
		
	}
	
	@GetMapping(value = "/getAllEmployeeData")
	public List<Employee> addEmployeeData() {
		
		return employeeService.getAllEmployeeData();
		
	}
	
	@GetMapping(value = "/getAllEmployeeDataStream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> addEmployeeDataStream() {
		
		return employeeService.getAllEmployeeDataStream();
		
	}

}
