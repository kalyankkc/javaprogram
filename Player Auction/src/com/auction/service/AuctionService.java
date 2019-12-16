package com.auction.service;

import java.util.List;
import java.util.Set;

import com.auction.entity.Player;
import com.auction.entity.Team;
import com.auction.exception.serviceexception.AuctionServiceException;

public interface AuctionService {
	
	public Set<Team> getTeamFromDao() throws AuctionServiceException;
	public List<Player> getPlayerFromDao() throws AuctionServiceException;
	public boolean setPlayerInDB(Player players) throws AuctionServiceException;
	public List<Player> getPlayersByTeam(String team) throws AuctionServiceException;

}
