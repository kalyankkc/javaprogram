package com.auction.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.auction.dao.daoimpl.AuctionDaoImpl;
import com.auction.entity.Player;
import com.auction.entity.Team;
import com.auction.entity.TeamPlayer;
import com.auction.exception.daoexception.AuctionDaoException;
import com.auction.exception.serviceexception.AuctionServiceException;
import com.auction.exception.serviceexception.InvalidCatagoryException;
import com.auction.exception.serviceexception.InvalivTeamNameException;
import com.auction.exception.serviceexception.NotABatsmanException;
import com.auction.exception.serviceexception.NotBowlerException;
import com.auction.service.AuctionService;

public class ActionServiceImpl implements AuctionService {

	static AuctionDaoImpl daoImpl = new AuctionDaoImpl();

	@Override
	public Set<Team> getTeamFromDao() throws AuctionServiceException {
		Set<Team> result = new HashSet<>();
		try {
			result = daoImpl.getTeamFromDB();
		} catch (AuctionDaoException e) {
			throw new AuctionServiceException(e);
		}
		return result;
	}

	@Override
	public List<Player> getPlayerFromDao() throws AuctionServiceException {
		List<Player> result = new ArrayList<>();
		try {
			result = daoImpl.gatPlayerFromDB();
		} catch (AuctionDaoException e) {
			throw new AuctionServiceException(e);
		}
		return result;
	}

	public boolean checkPlayer(String catagory, int score, String figure, String team) throws AuctionServiceException {
		boolean check = true;
		int teamId=0;
		try {
			if (catagory.equalsIgnoreCase("batsman") || catagory.equalsIgnoreCase("bolwer")
					|| catagory.equalsIgnoreCase("allrounder")) {
				if (catagory.equalsIgnoreCase("batsman")) {
					if (score >= 50 && score <= 200) {
						check = true;
					} else {
						check = false;
						throw new NotABatsmanException("Not a batsman");
					}
				} else if (catagory.equalsIgnoreCase("bolwer")) {
					if (figure.equals(null) || score < 0) {
						check = false;
						throw new NotBowlerException("Not a bolwer");
					} else {
						check = true;
					}
				}
			} else {
				throw new InvalidCatagoryException("INVALID CATAGORY");
			}

			Set<Team> teams = getTeamFromDao();
			for (Team team2 : teams) {
				if (team.equalsIgnoreCase(team2.getTeamName())) {
					teamId = team2.getTeamId();
					check = true;
					break;
				} else {
					check = false;
				}
			}
			if (check == false) {
				throw new InvalivTeamNameException("INVALID TEAM NAME");
			}

		} catch (InvalidCatagoryException e) {
			throw new AuctionServiceException(e);
		} catch (NotABatsmanException e) {
			throw new AuctionServiceException(e);
		} catch (NotBowlerException e) {
			throw new AuctionServiceException(e);
		} catch (InvalivTeamNameException e) {
			throw new AuctionServiceException(e);
		}
		int nextPlayerId=0;
		if (check == true) {
			List<Player> players = getPlayerFromDao();
			if (players == null) {
				nextPlayerId = 1;
			} else {
				Player lastPlayer = players.get(players.size()-1);
				nextPlayerId = lastPlayer.getPlayerNo() + 1;
			}
			TeamPlayer teamPlayer=new TeamPlayer(teamId,nextPlayerId);
			try {
				daoImpl.setTeamPlayerInDB(teamPlayer);
			} catch (AuctionDaoException e) {
				throw new AuctionServiceException(e);
			}
		}

		return check;
	}

	@Override
	public boolean setPlayerInDB(Player player) throws AuctionServiceException {
		boolean chk;
		try {
			chk = daoImpl.setPlayerInDB(player);
		} catch (AuctionDaoException e) {
			throw new AuctionServiceException(e);
		}
		return chk;
	}

	@Override
	public List<Player> getPlayersByTeam(String team) throws AuctionServiceException {
		List<Player> result = new ArrayList<>();
		Set<Team> teams;
		int teamId=0;
		boolean check = false;
		try {
			teams = getTeamFromDao();
			for (Team team2 : teams) {
				if (team.equalsIgnoreCase(team2.getTeamName())) {
					teamId = team2.getTeamId();
					check = true;
					break;
				} else {
					check = false;
				}
			}
			if (check == false) {
				throw new InvalivTeamNameException("INVALID TEAM NAME");
			}
		} catch (InvalivTeamNameException e) {
			throw new AuctionServiceException(e);
		}
		return result;
	}

}
