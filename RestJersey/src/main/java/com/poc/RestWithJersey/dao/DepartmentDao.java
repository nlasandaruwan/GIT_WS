package com.poc.RestWithJersey.dao;

import java.util.List;

import com.poc.RestWithJersey.domain.Department;

public interface DepartmentDao {

	public Department getDepartmentById(int id);
	public Department getDepartmentByIdAndDept(int id, String dept);
	public Department getDepartmentByName(String name);
	public List<Department> getDepartments();
	public List<Department> getDepartmentsByname(String name);
	public Department addDepartment(Department Department);
	public Department updateDepartment(Department Department);
}
