package com.mindtree.cafemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cafe {

	@Id
	@Column(name="CafeId")
	private int cafeId;
	
	@Column(name="CafeName")
	private String cafeName;
	
	@Column(name="CafeRev")
	private double cafeRevenue;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ManagerID",referencedColumnName = "ManagerId")
	private Manager manager;

	public Cafe() {
		super();
	}

	public Cafe(int cafeId, String cafeName, double cafeRevenue, Manager manager) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.cafeRevenue = cafeRevenue;
		this.manager = manager;
	}

	public Cafe(int cafeId, String cafeName, double cafeRevenue) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.cafeRevenue = cafeRevenue;
	}

	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public double getCafeRevenue() {
		return cafeRevenue;
	}

	public void setCafeRevenue(double cafeRevenue) {
		this.cafeRevenue = cafeRevenue;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	
}
