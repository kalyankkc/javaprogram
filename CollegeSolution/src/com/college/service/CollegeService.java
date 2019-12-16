package com.college.service;

import java.util.Set;

import com.college.entity.Category;
import com.college.entity.Problem;
import com.college.entity.Solution;

public interface CollegeService {
	
	Set<Category> getCategoryFromDao();
	Set<Problem> getProblemFromDao();
	void setSolutioninDao(Set<Solution> solution);

}
