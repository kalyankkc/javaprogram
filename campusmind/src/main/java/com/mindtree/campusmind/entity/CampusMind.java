package com.mindtree.campusmind.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class CampusMind {
	@Id
	@Column(name="MID")
	private int mid;
	
	@Column(name="Name",length=50)
	private String name;
	
	@Column(name="City",length=50)
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Laptop_Id")
	private Laptop laptop;
	
	public CampusMind() {
		super();
	}
	public CampusMind(String name, String city, Laptop laptop) {
		super();
		this.name = name;
		this.city = city;
		this.laptop = laptop;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
		
}
