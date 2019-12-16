package com.mindtree.department.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	@Column(name="EXPERINSE")
	private int experiense;
	@Column(name = "SALARY")
	private int salary;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="DEPARMENT_ID",referencedColumnName = "DEPARMENT_ID")
	private Department department;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, int experiense, int salary, Department department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.experiense = experiense;
		this.salary = salary;
		this.department = department;
	}

	public Employee(int employeeId, String employeeName, int experiense, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.experiense = experiense;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + experiense;
		result = prime * result + salary;
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
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (experiense != other.experiense)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", experiense=" + experiense
				+ ", salary=" + salary + ", department=" + department + "]";
	}

	

}
