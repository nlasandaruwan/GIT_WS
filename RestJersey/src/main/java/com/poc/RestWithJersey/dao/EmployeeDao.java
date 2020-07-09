package com.poc.RestWithJersey.dao;

import java.util.List;

import com.poc.RestWithJersey.domain.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(int id);
	public Employee getEmployeeByIdAndDept(int id, String dept);
	public Employee getEmployeeByName(String name);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByname(String name);
	public Employee addEmployees(Employee employee);
	public Employee updateEmployees(Employee employee);
	public Employee deleteEmployees(int id);
}
