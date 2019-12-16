package com.mindtree.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.department.dto.DepartmentDto;
import com.mindtree.department.exception.serviceexception.DepartmentServiceException;
import com.mindtree.department.service.DepartmentService;
 
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService serviceDep;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> setDepartmentInService(@RequestBody DepartmentDto departmentDto) {
		String isSet = serviceDep.setDepartment(departmentDto);
		HttpHeaders header=new HttpHeaders();
		header.add("SET","DEPARTMENT SAVE IN DATABASE");
		return new ResponseEntity<String>(isSet,header,HttpStatus.OK);
		
	}
	
	@RequestMapping
	public ResponseEntity<List<DepartmentDto>> getDepartments() {
		List<DepartmentDto> departments=serviceDep.getDepartmentFromDB();
		HttpHeaders header=new HttpHeaders();
		header.add("Get","ALL DEPARTMENT");
		return new ResponseEntity<List<DepartmentDto>>(departments,header,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable int id) throws DepartmentServiceException{
		DepartmentDto department = serviceDep.getDepartmentByIdFromDB(id);
		  HttpHeaders headers = new HttpHeaders();
		    headers.add("id","DEPARTMENT BY ID");
		return new ResponseEntity<DepartmentDto>(department,headers,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "/{id}")
	public String updateDepartment(@RequestBody DepartmentDto departmentDto,@PathVariable int id) {
		String isUpdated = serviceDep.updateDepartmentInDB(departmentDto,id);
		return isUpdated;
	}

	@RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
	public String deleteDepartment(@PathVariable int id) {
		String isDeleted=serviceDep.deleteDepartmentFromDB(id);
		return isDeleted;
	}
}
