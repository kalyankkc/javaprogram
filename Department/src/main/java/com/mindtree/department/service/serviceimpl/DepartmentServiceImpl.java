package com.mindtree.department.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.department.dto.DepartmentDto;
import com.mindtree.department.dto.EmployeeDto;
import com.mindtree.department.entity.Department;
import com.mindtree.department.entity.Employee;
import com.mindtree.department.exception.serviceexception.DepartmentServiceException;
import com.mindtree.department.exception.serviceexception.NoSuchDepartmentException;
import com.mindtree.department.repository.DepartmentRepository;
import com.mindtree.department.repository.EmployeeRepository;
import com.mindtree.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository repositoryDept;
	@Autowired
	EmployeeRepository repositoryEmp;

	static ModelMapper modelmapper=new ModelMapper();
	@Override
	public String setDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		department.setDepartmentName(departmentDto.getDepartmentName());
		
		Set<Employee> employees = new HashSet<>();
		for (EmployeeDto employeeDto : departmentDto.getEmployees()) {
			Employee employee = new Employee();
			employee.setEmployeeName(employeeDto.getEmployeeName());
			employee.setExperiense(employeeDto.getExperiense());
			employee.setSalary(employeeDto.getExperiense()*2000);
			employee.setDepartment(department);
			employees.add(employee);
		}
		department.setEmployees(employees);
		repositoryDept.save(department);

		
		return "DEPARTMENT SAVE";
	}
	@Override
	public List<DepartmentDto> getDepartmentFromDB() {
		List<Department> departments=repositoryDept.findAll();
		DepartmentDto departmentDto = new DepartmentDto();
		List<DepartmentDto>departmentDtos=new ArrayList<>();
		for (Department department : departments) {
			departmentDto=modelmapper.map(department, DepartmentDto.class);
			departmentDtos.add(departmentDto);
		}
		return departmentDtos;
	}
	@Override
	public DepartmentDto getDepartmentByIdFromDB(int id) throws DepartmentServiceException  {
		Optional<Department> dep = repositoryDept.findById(id);
		try {
		if(!dep.isPresent()) {
			throw new NoSuchDepartmentException("INVALID DEPARTMENT ID ");
		}
		}catch(NoSuchDepartmentException e) {
			throw new DepartmentServiceException(e);
		}
		DepartmentDto departmentDto = modelmapper.map(dep.get(), DepartmentDto.class);

		return departmentDto;
	}
	@Override
	public String updateDepartmentInDB(DepartmentDto departmentDto, int id) {
		Department department = new Department();
		department.setDepartmentName(departmentDto.getDepartmentName());
		
		Set<Employee> employees = new HashSet<>();
		for (EmployeeDto employeeDto : departmentDto.getEmployees()) {
			Employee employee = new Employee();
			employee.setEmployeeName(employeeDto.getEmployeeName());
			employee.setExperiense(employeeDto.getExperiense());
			employee.setSalary(employeeDto.getExperiense()*2000);
			employee.setDepartment(department);
			employees.add(employee);
		}
		department.setEmployees(employees);
		repositoryDept.saveAndFlush(department);
		return "Updated";
	}
	@Override
	public String deleteDepartmentFromDB(int id) {
		repositoryDept.deleteById(id);
		return "Deleted";
	}

}
