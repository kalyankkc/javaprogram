package com.mindtree.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
