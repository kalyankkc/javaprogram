package com.college.entity;

public class Problem {
	private int probId;
	private String probName;
	private String probDescription;
	private String category;
	private String solution;
	public Problem() {
		super();
	}
	public Problem(int probId, String probName, String probDescription, String category) {
		super();
		this.probId = probId;
		this.probName = probName;
		this.probDescription = probDescription;
		this.category = category;
	}
	public Problem(int probId, String probName, String probDescription) {
		super();
		this.probId = probId;
		this.probName = probName;
		this.probDescription = probDescription;
	}
	
	public Problem(int probId, String probName, String probDescription, String category, String solution) {
		super();
		this.probId = probId;
		this.probName = probName;
		this.probDescription = probDescription;
		this.category = category;
		this.solution = solution;
	}
	public int getProbId() {
		return probId;
	}
	public void setProbId(int probId) {
		this.probId = probId;
	}
	public String getProbName() {
		return probName;
	}
	public void setProbName(String probName) {
		this.probName = probName;
	}
	public String getProbDescription() {
		return probDescription;
	}
	public void setProbDescription(String probDescription) {
		this.probDescription = probDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((probDescription == null) ? 0 : probDescription.hashCode());
		result = prime * result + probId;
		result = prime * result + ((probName == null) ? 0 : probName.hashCode());
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
		Problem other = (Problem) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (probDescription == null) {
			if (other.probDescription != null)
				return false;
		} else if (!probDescription.equals(other.probDescription))
			return false;
		if (probId != other.probId)
			return false;
		if (probName == null) {
			if (other.probName != null)
				return false;
		} else if (!probName.equals(other.probName))
			return false;
		return true;
	}
	

	

}
