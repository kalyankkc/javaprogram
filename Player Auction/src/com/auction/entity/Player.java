package com.auction.entity;

public class Player {

	private int playerNo;
	private String playerName;
	private String catagory;
	private int highestScore;
	private String bestFigure;

	public Player() {
		super();
	}

	public Player(int playerNo, String playerName, String catagory, int highestScore, String bestFigure) {
		super();
		this.playerNo = playerNo;
		this.playerName = playerName;
		this.catagory = catagory;
		this.highestScore = highestScore;
		this.bestFigure = bestFigure;
	}

	public Player(String playerName, String catagory, int highestScore, String bestFigure) {
		super();
		this.playerName = playerName;
		this.catagory = catagory;
		this.highestScore = highestScore;
		this.bestFigure = bestFigure;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public String getBestFigure() {
		return bestFigure;
	}

	public void setBestFigure(String bestFigure) {
		this.bestFigure = bestFigure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestFigure == null) ? 0 : bestFigure.hashCode());
		result = prime * result + ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result + highestScore;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + playerNo;
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
		Player other = (Player) obj;
		if (bestFigure == null) {
			if (other.bestFigure != null)
				return false;
		} else if (!bestFigure.equals(other.bestFigure))
			return false;
		if (catagory == null) {
			if (other.catagory != null)
				return false;
		} else if (!catagory.equals(other.catagory))
			return false;
		if (highestScore != other.highestScore)
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (playerNo != other.playerNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [playerNo=" + playerNo + ", playerName=" + playerName + ", catagory=" + catagory
				+ ", highestScore=" + highestScore + ", bestFigure=" + bestFigure + "]";
	}

}
