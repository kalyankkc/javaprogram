package com.movie.entity;

public class Movie {
	private int movId;
	private String movName;
	private int budget;

	public Movie() {
		super();
	}

	public Movie(int movId, String movName, int budget) {
		super();
		this.movId = movId;
		this.movName = movName;
		this.budget = budget;
	}

	public int getMovId() {
		return movId;
	}

	public void setMovId(int movId) {
		this.movId = movId;
	}

	public String getMovName() {
		return movName;
	}

	public void setMovName(String movName) {
		this.movName = movName;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + budget;
		result = prime * result + movId;
		result = prime * result + ((movName == null) ? 0 : movName.hashCode());
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
		Movie other = (Movie) obj;
		if (budget != other.budget)
			return false;
		if (movId != other.movId)
			return false;
		if (movName == null) {
			if (other.movName != null)
				return false;
		} else if (!movName.equals(other.movName))
			return false;
		return true;
	}

}
