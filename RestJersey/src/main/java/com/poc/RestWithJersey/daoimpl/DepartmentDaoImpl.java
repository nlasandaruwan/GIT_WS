package com.poc.RestWithJersey.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.poc.RestWithJersey.dao.DepartmentDao;
import com.poc.RestWithJersey.domain.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	List<Department> departmentList = new ArrayList<Department>();

	public DepartmentDaoImpl() {
		departmentList.add(new Department(1, "IT", "IT", 1000000));
		departmentList.add(new Department(2, "Financial", "Financial", 1000000));
		departmentList.add(new Department(3, "S and B", "S and B", 1000000));
		departmentList.add(new Department(4, "Management", "Management", 1000000));
	}

	@Override
	public Department getDepartmentById(int id) {

		for (Department Department : departmentList) {
			if (Department.getDepartmentId() == id) {
				return Department;
			}
		}
		return null;
	}

	@Override
	public Department getDepartmentByName(String name) {
		for (Department Department : departmentList) {
			if (Department.getDepartmentName().equalsIgnoreCase(name)) {
				return Department;
			}
		}
		return null;
	}

	@Override
	public List<Department> getDepartments() {
		return departmentList;
	}

	@Override
	public Department addDepartment(Department Department) {
		if (Department != null && !departmentList.contains(Department)) {
			departmentList.add(Department);
			return Department;
		}
		return null;
	}

	@Override
	public Department updateDepartment(Department Department) {
		if (Department != null && departmentList.contains(Department)) {
			departmentList.remove(Department);
			departmentList.add(Department);
			return Department;
		}
		return null;
	}

	@Override
	public Department getDepartmentByIdAndDept(int id, String dept) {
		for (Department Department : departmentList) {
			if (Department.getDepartmentId() == id && Department.getDepartmentName().equals(dept)) {
				return Department;
			}
		}
		return null;
	}

	@Override
	public List<Department> getDepartmentsByname(String name) {

		List<Department> list = new ArrayList<Department>();
		for (Department Department : departmentList) {
			if (Department.getDepartmentName().contains(name)) {
				list.add(Department);
				return list;
			}
		}
		return null;
	}

}
