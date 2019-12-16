package com.mindtree.cafemanagement.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.cafemanagement.dto.CafeDto;
import com.mindtree.cafemanagement.exception.serviceexception.CafeManagementServiceException;

@Service
public interface CafeManagementService {

	public String addCafe(CafeDto cafeDto);
	public List<CafeDto> getCafesByManager(int mId) throws CafeManagementServiceException;
	public List<CafeDto> allCafeByRevenue(int rev) throws CafeManagementServiceException;
}
