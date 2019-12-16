package com.mindtree.campusmind.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.campusmind.entity.CampusMind;
import com.mindtree.campusmind.entity.Laptop;
import com.mindtree.campusmind.service.CampusmindService;

@RestController
public class CampusmindControler {
	@Autowired
	private CampusmindService objsc;
	
	@PostMapping("/campusminds")
	private CampusMind saveCM(@RequestBody CampusMind c) {
		return objsc.saveCampusMind(c);
	}
	@GetMapping("/getlaptop/{id}")
	private Laptop getLaptop(@PathVariable int id) {
		Laptop l = objsc.getlaptops(id);
		return l;
	}
	
}
