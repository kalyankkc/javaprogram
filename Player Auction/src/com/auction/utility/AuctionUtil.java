package com.auction.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.auction.exception.daoexception.InvalidConnectionException;

public class AuctionUtil {
	private String URL = "jdbc:mysql://localhost:3306/player_DB";
	private String User = "root";
	private String password = "root";

	public Connection getConnection() throws InvalidConnectionException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, User, password);
		} catch (SQLException e) {
			throw new InvalidConnectionException(e);
		}
		return con;
	}

}
