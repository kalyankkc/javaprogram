package com.mindtree.department.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class EmployeeDto {
	private String employeeName;
	private int experiense;
	
	@JsonIgnoreProperties("employees")
	private DepartmentDto department;
	
	public EmployeeDto() {
	super();
	}

	public EmployeeDto(String employeeName, int experiense, DepartmentDto department) {
		super();
		this.employeeName = employeeName;
		this.experiense = experiense;
		this.department = department;
	}

	public EmployeeDto(String employeeName, int experiense) {
		super();
		this.employeeName = employeeName;
		this.experiense = experiense;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getExperiense() {
		return experiense;
	}

	public void setExperiense(int experiense) {
		this.experiense = experiense;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + experiense;
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
		EmployeeDto other = (EmployeeDto) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (experiense != other.experiense)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeName=" + employeeName + ", experiense=" + experiense + ", department=" + department
				+ "]";
	}


	

}
