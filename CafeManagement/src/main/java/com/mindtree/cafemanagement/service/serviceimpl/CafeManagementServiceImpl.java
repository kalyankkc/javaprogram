package com.mindtree.cafemanagement.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cafemanagement.dto.CafeDto;
import com.mindtree.cafemanagement.dto.ManagerDto;
import com.mindtree.cafemanagement.entity.Cafe;
import com.mindtree.cafemanagement.entity.Manager;
import com.mindtree.cafemanagement.exception.serviceexception.CafeManagementServiceException;
import com.mindtree.cafemanagement.exception.serviceexception.serviceexceptionimpl.ManagerNotFoundException;
import com.mindtree.cafemanagement.exception.serviceexception.serviceexceptionimpl.NoSuchCafePresentException;
import com.mindtree.cafemanagement.repository.CafeRepository;
import com.mindtree.cafemanagement.repository.ManagerRpository;
import com.mindtree.cafemanagement.service.CafeManagementService;

@Service
public class CafeManagementServiceImpl implements CafeManagementService {
	
	@Autowired
	CafeRepository cr;
	
	@Autowired
	ManagerRpository mr;

	@Override
	public String addCafe(CafeDto cafeDto) {
		Cafe cafe = new Cafe();
		cafe.setCafeId(cafeDto.getCafeIdDto());
		cafe.setCafeName(cafeDto.getCafeNameDto());
		cafe.setCafeRevenue(cafeDto.getCafeRevenueDto());
		
		//Setting MnagerDto To Manager
		Manager manager = new Manager();
		manager.setManagerId(cafeDto.getManagerDto().getManagerIdDto());
		manager.setManageerName(cafeDto.getManagerDto().getManageerNameDto());
		manager.setManagerSalary(cafeDto.getManagerDto().getManagerSalaryDto());
		
		cafe.setManager(manager);
		cr.save(cafe);
		
		List<Cafe> cafes=new ArrayList<>();
		cafes.add(cafe);
		manager.setCafe(cafes);
		mr.save(manager);
			
		return "Data Inserted";
	}

	@Override
	public List<CafeDto> getCafesByManager(int mId) throws CafeManagementServiceException {
		List<CafeDto> cafesDto= new ArrayList<>();
		try {		
		Manager manager = new Manager();
		List<Manager> managers = mr.findAll();
		int c =managers.size();
		for (Manager manage : managers) {
			if(manage.getManagerId()==mId) {
				manager=manage;
			}
			else {
				c--;
				if(c==0)
				throw new ManagerNotFoundException("Manager not exist");
					
			}
		}
		List<Cafe> cafes =  manager.getCafe();
		for (Cafe cafe : cafes) {
			CafeDto cafeD = new CafeDto();
			cafeD.setCafeIdDto(cafe.getCafeId());
			cafeD.setCafeNameDto(cafe.getCafeName());
			cafeD.setCafeRevenueDto(cafe.getCafeRevenue());
			cafesDto.add(cafeD);
		}
		}catch(ManagerNotFoundException e) {
			throw new CafeManagementServiceException(e);
		}
		return cafesDto;
	}

	@Override
	public List<CafeDto> allCafeByRevenue(int rev) throws CafeManagementServiceException {
		List<CafeDto> cafesDto= new ArrayList<>();
		List<Cafe> caf= new ArrayList<>();
		List<Cafe> cafes = cr.findAll();
		int c=cafes.size();
		for (Cafe cafe : cafes) {
			if(cafe.getCafeRevenue()>rev) {
				caf.add(cafe);
			}
			else {
				c--;
			}
		}
		try {
		if(c==0) 
			throw new NoSuchCafePresentException("Cafe not found");
		else {
		for (Cafe cafe : caf) {
			CafeDto cafeD = new CafeDto();
			cafeD.setCafeIdDto(cafe.getCafeId());
			cafeD.setCafeNameDto(cafe.getCafeName());
			cafeD.setCafeRevenueDto(cafe.getCafeRevenue());
			
			ManagerDto manager = new ManagerDto();
			manager.setManagerIdDto(cafe.getManager().getManagerId());
			manager.setManageerNameDto(cafe.getManager().getManageerName());
			manager.setManagerSalaryDto(cafe.getManager().getManagerSalary());
			
			cafeD.setManagerDto(manager);
			
			cafesDto.add(cafeD);
		 }
		}
		
		}catch(NoSuchCafePresentException e) {
			throw new CafeManagementServiceException(e);
		}
		return cafesDto;
	}

}
