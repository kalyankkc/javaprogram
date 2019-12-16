package com.college.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CollegeUtil {

	private final String URL = "jdbc:mysql://localhost:3306/pratice";
	private final String USER_NAME = "root";
	private final String PASSWORD = "root";

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//System.out.println("connected");
		return conn;

	}

}
