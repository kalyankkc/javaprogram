package com.mindtree.campusmind.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.campusmind.entity.CampusMind;
import com.mindtree.campusmind.entity.Laptop;

@Service
public interface CampusmindService {

	CampusMind saveCampusMind(CampusMind campusmind);
	Laptop getlaptops(int id);
	List<CampusMind> getMinds();
	
}
