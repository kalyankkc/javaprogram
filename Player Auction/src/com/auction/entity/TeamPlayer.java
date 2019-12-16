package com.auction.entity;

public class TeamPlayer {

	private int teamID;
	private int playerNO;
	
	public TeamPlayer() {
		super();
	}

	public TeamPlayer(int teamID, int playerNO) {
		super();
		this.teamID = teamID;
		this.playerNO = playerNO;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public int getPlayerNO() {
		return playerNO;
	}

	public void setPlayerNO(int playerNO) {
		this.playerNO = playerNO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + playerNO;
		result = prime * result + teamID;
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
		TeamPlayer other = (TeamPlayer) obj;
		if (playerNO != other.playerNO)
			return false;
		if (teamID != other.teamID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamPlayer [teamID=" + teamID + ", playerNO=" + playerNO + "]";
	}
	
	
}
