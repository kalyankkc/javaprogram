package com.mindtree.cafemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cafemanagement.dto.CafeDto;
import com.mindtree.cafemanagement.exception.serviceexception.CafeManagementServiceException;
import com.mindtree.cafemanagement.service.serviceimpl.CafeManagementServiceImpl;

@RestController
public class CafeManagementControl {

	@Autowired
	CafeManagementServiceImpl cafemanage;
	
	@PostMapping("/addCafeWithManager")
	private String addingCafe(@RequestBody CafeDto cafeDto) {
		String res = cafemanage.addCafe(cafeDto);
		return res;
	}
	@GetMapping("/getCafesByManager/{mId}")
	private List<CafeDto> allCafesByManager(@PathVariable int mId){
		List<CafeDto> cafesDto= new ArrayList<>();
		try {
			cafesDto=cafemanage.getCafesByManager(mId);
		} catch (CafeManagementServiceException e) {
			System.out.println(e.getMessage());
		}
		return cafesDto;
	}
	@GetMapping("/cafeByRevenue/{rev}")
	private List<CafeDto> cafeByRevenue(@PathVariable int rev){
		List<CafeDto> cafesDto= new ArrayList<>();
		try {
			cafesDto=cafemanage.allCafeByRevenue(rev);
		} catch (CafeManagementServiceException e) {
			System.out.println(e.getMessage());
		}
		return cafesDto;
	}
}
