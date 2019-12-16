package com.college.dao;

import java.util.Set;

import com.college.entity.Category;
import com.college.entity.Problem;
import com.college.entity.Solution;

public interface CollegeDao {
	Set<Category> getCategoryFromDB();
	Set<Problem> getProblemFromDB();
	void setSolutionInDB(Set<Solution> sol);

}
