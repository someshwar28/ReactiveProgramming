package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
