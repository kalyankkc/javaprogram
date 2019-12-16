package com.mindtree.cafemanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CafeDto {
	
	private int cafeIdDto;
	private String cafeNameDto;
	private double cafeRevenueDto;
	
	@JsonIgnoreProperties("cafeDto")
	private ManagerDto managerDto;

	public CafeDto() {
		super();
	}

	public CafeDto(int cafeIdDto, String cafeNameDto, double cafeRevenueDto, ManagerDto managerDto) {
		super();
		this.cafeIdDto = cafeIdDto;
		this.cafeNameDto = cafeNameDto;
		this.cafeRevenueDto = cafeRevenueDto;
		this.managerDto = managerDto;
	}

	public CafeDto(int cafeIdDto, String cafeNameDto, double cafeRevenueDto) {
		super();
		this.cafeIdDto = cafeIdDto;
		this.cafeNameDto = cafeNameDto;
		this.cafeRevenueDto = cafeRevenueDto;
	}

	public int getCafeIdDto() {
		return cafeIdDto;
	}

	public void setCafeIdDto(int cafeIdDto) {
		this.cafeIdDto = cafeIdDto;
	}

	public String getCafeNameDto() {
		return cafeNameDto;
	}

	public void setCafeNameDto(String cafeNameDto) {
		this.cafeNameDto = cafeNameDto;
	}

	public double getCafeRevenueDto() {
		return cafeRevenueDto;
	}

	public void setCafeRevenueDto(double cafeRevenueDto) {
		this.cafeRevenueDto = cafeRevenueDto;
	}

	public ManagerDto getManagerDto() {
		return managerDto;
	}

	public void setManagerDto(ManagerDto managerDto) {
		this.managerDto = managerDto;
	}
	

	
}
