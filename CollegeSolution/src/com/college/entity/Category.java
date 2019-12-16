package com.college.entity;

import java.util.Set;

public class Category {
	private int id;
	private String categoryName;
	private Set <Problem> problem;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String categoryName, Set<Problem> problem) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.problem = problem;
	}
	public Category(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Problem> getProblem() {
		return problem;
	}
	public void setProblem(Set<Problem> problem2) {
		this.problem = problem2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + id;
		result = prime * result + ((problem == null) ? 0 : problem.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (id != other.id)
			return false;
		if (problem == null) {
			if (other.problem != null)
				return false;
		} else if (!problem.equals(other.problem))
			return false;
		return true;
	}
	
}
