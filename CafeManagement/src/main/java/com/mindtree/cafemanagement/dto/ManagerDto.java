package com.mindtree.cafemanagement.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ManagerDto {

	private int managerIdDto;
	private String manageerNameDto;
	private double managerSalaryDto;
	
	@JsonIgnoreProperties("manaagerDto")
	private List<CafeDto> cafeDto;

	public ManagerDto() {
		super();
	}

	public ManagerDto(int managerIdDto, String manageerNameDto, double managerSalaryDto, List<CafeDto> cafeDto) {
		super();
		this.managerIdDto = managerIdDto;
		this.manageerNameDto = manageerNameDto;
		this.managerSalaryDto = managerSalaryDto;
		this.cafeDto = cafeDto;
	}

	public ManagerDto(int managerIdDto, String manageerNameDto, double managerSalaryDto) {
		super();
		this.managerIdDto = managerIdDto;
		this.manageerNameDto = manageerNameDto;
		this.managerSalaryDto = managerSalaryDto;
	}

	public int getManagerIdDto() {
		return managerIdDto;
	}

	public void setManagerIdDto(int managerIdDto) {
		this.managerIdDto = managerIdDto;
	}

	public String getManageerNameDto() {
		return manageerNameDto;
	}

	public void setManageerNameDto(String manageerNameDto) {
		this.manageerNameDto = manageerNameDto;
	}

	public double getManagerSalaryDto() {
		return managerSalaryDto;
	}

	public void setManagerSalaryDto(double managerSalaryDto) {
		this.managerSalaryDto = managerSalaryDto;
	}

	public List<CafeDto> getCafeDto() {
		return cafeDto;
	}

	public void setCafeDto(List<CafeDto> cafeDto) {
		this.cafeDto = cafeDto;
	}
	
}
