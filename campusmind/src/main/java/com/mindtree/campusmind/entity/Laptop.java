package com.mindtree.campusmind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id
	@Column(name="Laptop_Id")
	private int laptopId;
	
	@Column(name="Laptop_Brand",length = 50)
	private String brand;
	
	@Column(name="Laptop_Prise")
	private double prise;
	
	public Laptop() {
		super();
	}
	public Laptop(int laptopId, String brand, double prise) {
		super();
		this.laptopId = laptopId;
		this.brand = brand;
		this.prise = prise;
	}
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrise() {
		return prise;
	}
	public void setPrise(double prise) {
		this.prise = prise;
	}
	
}
