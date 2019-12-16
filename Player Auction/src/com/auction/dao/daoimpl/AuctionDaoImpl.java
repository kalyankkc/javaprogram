package com.auction.dao.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.auction.dao.AuctionDao;
import com.auction.entity.Player;
import com.auction.entity.Team;
import com.auction.entity.TeamPlayer;
import com.auction.exception.daoexception.AuctionDaoException;
import com.auction.exception.daoexception.InvalidConnectionException;
import com.auction.utility.AuctionUtil;

public class AuctionDaoImpl implements AuctionDao {

	static AuctionUtil util = new AuctionUtil();
	static Connection con = null;
	static Statement stm = null;

	@Override
	public Set<Team> getTeamFromDB() throws AuctionDaoException {
		Set<Team> result = new HashSet<>();
		try {
			con = util.getConnection();
		} catch (InvalidConnectionException e) {
			throw new AuctionDaoException(e);
		}
		String query = "select * from TEAM ;";
		ResultSet rs = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(query);
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}

		try {
			while (rs.next()) {
				Team team = new Team();
				team.setTeamId(rs.getInt(1));
				team.setTeamName(rs.getString(2));
				result.add(team);

			}
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}

		closeAll();

		return result;
	}

	@Override
	public boolean setPlayerInDB(Player player) throws AuctionDaoException {
		boolean chk = false;
		try {
			con = util.getConnection();
		} catch (InvalidConnectionException e) {
			throw new AuctionDaoException(e);
		}
		String query = "INSERT INTO PlAYER VALUES (default,'" + player.getPlayerName() + "','" + player.getCatagory()
				+ "'," + player.getHighestScore() + ",'" + player.getBestFigure() + "');";
		try {
			stm = con.createStatement();
			stm.executeUpdate(query);
			chk = true;
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}
		closeAll();

		return chk;
	}
	@Override
	public boolean setTeamPlayerInDB(TeamPlayer teamPlayer) throws AuctionDaoException {
		boolean chk = false;
		try {
			con = util.getConnection();
		} catch (InvalidConnectionException e) {
			throw new AuctionDaoException(e);
		}
		String query = "INSERT INTO TEAM_PLAYER VALUES("+teamPlayer.getTeamID()+","+teamPlayer.getPlayerNO()+");" ;
		try {
			stm = con.createStatement();
			stm.executeUpdate(query);
			chk = true;
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}
		closeAll();

		return chk;

	}

	@Override
	public List<Player> gatPlayerFromDB() throws AuctionDaoException {
		List<Player> result = new ArrayList<>();
		try {
			con = util.getConnection();
		} catch (InvalidConnectionException e) {
			throw new AuctionDaoException(e);
		}
		String query = "select * from PLAYER ;";
		ResultSet rs = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(query);
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}

		try {
			while (rs.next()) {
				Player player = new Player();
				player.setPlayerNo(rs.getInt(1));
				player.setPlayerName(rs.getString(2));
				player.setCatagory(rs.getString(3));
				player.setHighestScore(rs.getInt(4));
				player.setBestFigure(rs.getString(5));
				result.add(player);

			}
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}

		closeAll();

		return result;
	}

	private void closeAll() throws AuctionDaoException {
		try {
			stm.close();
			con.close();
		} catch (SQLException e) {
			throw new AuctionDaoException(e);
		}
	}

}
