package com.mindtree.department.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DepartmentDto {
	private String departmentName;
	
	@JsonIgnoreProperties("department")
	private Set<EmployeeDto> employees = new HashSet<EmployeeDto>();
	
	public DepartmentDto() {
		super();
	}

	public DepartmentDto(String departmentName, Set<EmployeeDto> employees) {
		super();
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeDto> employees) {
		this.employees = employees;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
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
		DepartmentDto other = (DepartmentDto) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartmentDto [departmentName=" + departmentName + ", employees=" + employees + "]";
	}

	
	
}
