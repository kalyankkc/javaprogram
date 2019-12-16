package com.college.entity;

import java.util.Set;

public class Solution {
	private int solutionId;
	private String solutionDescription;
	private Set<Problem> probsol;
	public Solution() {
		super();
	}
	public Solution(int solutionId, String solutionDescription) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
	}
	public int getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	public String getSolutionDescription() {
		return solutionDescription;
	}
	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}
	
	public Solution(int solutionId, String solutionDescription, Set<Problem> probsol) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.probsol = probsol;
	}
	public Set<Problem> getProbsol() {
		return probsol;
	}
	public void setProbsol(Set<Problem> probsol) {
		this.probsol = probsol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((solutionDescription == null) ? 0 : solutionDescription.hashCode());
		result = prime * result + solutionId;
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
		Solution other = (Solution) obj;
		if (solutionDescription == null) {
			if (other.solutionDescription != null)
				return false;
		} else if (!solutionDescription.equals(other.solutionDescription))
			return false;
		if (solutionId != other.solutionId)
			return false;
		return true;
	}
	
}
