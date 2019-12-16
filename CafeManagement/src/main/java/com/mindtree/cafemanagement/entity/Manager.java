package com.mindtree.cafemanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manager {

	@Id
	@Column(name="ManagerId")
	private int managerId;
	
	@Column(name="ManagerName")
	private String manageerName;
	
	@Column(name="ManagerSalary")
	private double managerSalary;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "manager",fetch = FetchType.LAZY)
	private List<Cafe> cafe;

	public Manager() {
		super();
	}

	public Manager(int managerId, String manageerName, double managerSalary, List<Cafe> cafe) {
		super();
		this.managerId = managerId;
		this.manageerName = manageerName;
		this.managerSalary = managerSalary;
		this.cafe = cafe;
	}

	public Manager(int managerId, String manageerName, double managerSalary) {
		super();
		this.managerId = managerId;
		this.manageerName = manageerName;
		this.managerSalary = managerSalary;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManageerName() {
		return manageerName;
	}

	public void setManageerName(String manageerName) {
		this.manageerName = manageerName;
	}

	public double getManagerSalary() {
		return managerSalary;
	}

	public void setManagerSalary(double managerSalary) {
		this.managerSalary = managerSalary;
	}

	public List<Cafe> getCafe() {
		return cafe;
	}

	public void setCafe(List<Cafe> cafe) {
		this.cafe = cafe;
	}
	
	
	
}
