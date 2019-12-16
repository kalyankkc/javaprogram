package com.college.service.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import com.college.dao.daoimpl.CollegeDaoImpl;
import com.college.entity.Category;
import com.college.entity.Problem;
import com.college.entity.Solution;
import com.college.service.CollegeService;

public class CollegeServiceImpl implements CollegeService {
	static CollegeDaoImpl objd = new CollegeDaoImpl();

	@Override
	public Set<Category> getCategoryFromDao() {
		Set<Category> result=new HashSet<>();
		result = objd.getCategoryFromDB();
		return result;
	}

	@Override
	public Set<Problem> getProblemFromDao() {
		Set<Problem> result=new HashSet<>();
		result = objd.getProblemFromDB();
		return result;
	}

	@Override
	public void setSolutioninDao(Set<Solution> solution) {
		objd.setSolutionInDB(solution);
		
	}

}
