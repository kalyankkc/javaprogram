package com.mindtree.campusmind.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.campusmind.entity.CampusMind;
import com.mindtree.campusmind.entity.Laptop;
import com.mindtree.campusmind.repository.CampusmindRepository;
import com.mindtree.campusmind.repository.LaptopRepository;
import com.mindtree.campusmind.service.CampusmindService;

@Service
public class CampusMindServiceImpl implements CampusmindService {
    @Autowired
    private CampusmindRepository mind;
    @Autowired
    private LaptopRepository lap;
    
	@Override
	public CampusMind saveCampusMind(CampusMind campusmind) {
		
		return mind.save(campusmind);
	}
	@Override
	public Laptop getlaptops(int id) {
		List<CampusMind> minds=getMinds();
		int idl=0;
		for(CampusMind cm: minds) {
			if(cm.getMid()==id) {
				idl=cm.getLaptop().getLaptopId();
				break;
			}
		}
		return lap.getOne(idl);
	}
	@Override
	public List<CampusMind> getMinds() {
		return mind.getMinds();
	}

}
