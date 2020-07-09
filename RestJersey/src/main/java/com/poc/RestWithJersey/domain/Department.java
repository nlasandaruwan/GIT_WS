package com.poc.RestWithJersey.domain;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

@XmlRootElement

public class Department {

	@NotNull
	@FormParam("departmentId")
	private int departmentId;

	@NotNull
	@FormParam("departmentName")
	private String departmentName;

	@NotNull
	@Email
	@FormParam("departmentCategory")
	private String departmentCategory;

	@NotNull
	@FormParam("employeeCount")
	private int employeeCount;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentId, String departmentName, String departmentCategory, int employeeCount) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentCategory = departmentCategory;
		this.employeeCount = employeeCount;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCategory() {
		return departmentCategory;
	}

	public void setDepartmentCategory(String departmentCategory) {
		this.departmentCategory = departmentCategory;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentCategory=" + departmentCategory + ", employeeCount=" + employeeCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentCategory == null) ? 0 : departmentCategory.hashCode());
		result = prime * result + departmentId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + employeeCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentCategory == null) {
			if (other.departmentCategory != null)
				return false;
		} else if (!departmentCategory.equals(other.departmentCategory))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (employeeCount != other.employeeCount)
			return false;
		return true;
	}
}
