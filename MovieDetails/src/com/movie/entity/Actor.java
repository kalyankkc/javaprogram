package com.movie.entity;

public class Actor {

	private int actId;
	private String actName;

	public Actor() {
		super();
	}

	public Actor(int actId, String actName) {
		super();
		this.actId = actId;
		this.actName = actName;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actId;
		result = prime * result + ((actName == null) ? 0 : actName.hashCode());
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
		Actor other = (Actor) obj;
		if (actId != other.actId)
			return false;
		if (actName == null) {
			if (other.actName != null)
				return false;
		} else if (!actName.equals(other.actName))
			return false;
		return true;
	}

}
