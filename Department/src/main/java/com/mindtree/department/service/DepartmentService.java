package com.mindtree.department.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.department.dto.DepartmentDto;
import com.mindtree.department.exception.serviceexception.DepartmentServiceException;

@Service
public interface DepartmentService {
	public String setDepartment(DepartmentDto department);

	public List<DepartmentDto> getDepartmentFromDB();

	public DepartmentDto getDepartmentByIdFromDB(int id) throws DepartmentServiceException;

	public String updateDepartmentInDB(DepartmentDto departmentDto, int id);

	public String deleteDepartmentFromDB(int id);

}
