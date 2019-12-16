package com.movie.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.movie.exception.MovieDaoException;

public class MovieUtil {
	private String URL ="jdbc:mysql://localhost:3306/pratice";
	private String User="root";
	private String password="root";
	public Connection getConnection() throws MovieDaoException {
		Connection con=null;
		try {
			con = DriverManager.getConnection(URL,User,password);
		} catch (SQLException e) {
			throw new MovieDaoException(e);
		}
		return con;
	}

}
