package com.auction.dao;

import java.util.List;
import java.util.Set;

import com.auction.entity.Player;
import com.auction.entity.Team;
import com.auction.entity.TeamPlayer;
import com.auction.exception.daoexception.AuctionDaoException;

public interface AuctionDao {

	public Set<Team> getTeamFromDB() throws AuctionDaoException;

	public boolean setPlayerInDB(Player player) throws AuctionDaoException;

	public List<Player> gatPlayerFromDB() throws AuctionDaoException;

	public boolean setTeamPlayerInDB(TeamPlayer teamPlayer) throws AuctionDaoException;

}
