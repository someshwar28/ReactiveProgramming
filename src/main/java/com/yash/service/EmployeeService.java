package com.yash.service;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entity.Employee;
import com.yash.repository.EmployeeRepository;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployeeObject(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}
	
	public static void sleepExecuation(int time) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployeeData(){
		
		return IntStream.range(1, 3)
				.peek(EmployeeService::sleepExecuation)
				.peek(emp->System.out.println(emp))
				.mapToObj(emp->new Employee(101, "someshwar", "pune")).toList();
	}
	
	
	public Flux<Employee> getAllEmployeeDataStream(){
		
		 return Flux.range(1,10)
	                .delayElements(Duration.ofSeconds(1))
	                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
	                .map(i -> new Employee(i,"someshwar","pune"));
	}
	
	
	
	
	
	
	

}
