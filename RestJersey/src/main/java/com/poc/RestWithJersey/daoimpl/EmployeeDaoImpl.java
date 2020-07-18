package com.poc.RestWithJersey.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.poc.RestWithJersey.dao.EmployeeDao;
import com.poc.RestWithJersey.domain.Employee;

@javax.inject.Singleton
public class EmployeeDaoImpl implements EmployeeDao {

	List<Employee> employeeList = new ArrayList<Employee>();

	public EmployeeDaoImpl() {
		employeeList.add(new Employee(1, "Sandaruwan", "IT", 1000000));
		employeeList.add(new Employee(2, "Perera", "Financial", 1000000));
		employeeList.add(new Employee(3, "Telin", "Financial", 1000000));
		employeeList.add(new Employee(4, "Shelton", "Management", 1000000));
	}

	@Override
	public Employee getEmployeeById(int id) {

		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		for (Employee employee : employeeList) {
			if (employee.getName().equalsIgnoreCase(name)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeList;
	}

	@Override
	public Employee addEmployees(Employee employee) {
		if (employee != null && !employeeList.contains(employee)) {
			employeeList.add(employee);
			return employee;
		}
		return null;
	}

	@Override
	public Employee updateEmployees(Employee employee) {
		if (employee != null && employeeList.contains(employee)) {
			employeeList.remove(employee);
			employeeList.add(employee);
			return employee;
		}
		return null;
	}

	@Override
	public Employee getEmployeeByIdAndDept(int id, String dept) {
		for (Employee employee : employeeList) {
			if (employee.getId() == id && employee.getDept().equals(dept)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeesByname(String name) {

		List<Employee> list = new ArrayList<Employee>();
		for (Employee employee : employeeList) {
			if (employee.getName().contains(name)) {
				list.add(employee);
				return list;
			}
		}
		return null;
	}

	@Override
	public Employee deleteEmployees(int id) {
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
}
