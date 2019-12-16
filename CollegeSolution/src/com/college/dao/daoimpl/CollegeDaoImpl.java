package com.college.dao.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.college.dao.CollegeDao;
import com.college.entity.Category;
import com.college.entity.Problem;
import com.college.entity.Solution;
import com.college.utility.CollegeUtil;


public class CollegeDaoImpl implements CollegeDao {
		
static CollegeUtil obju = new CollegeUtil();


	@Override
	public Set<Category> getCategoryFromDB() {
		Set <Category> result = new HashSet<>();
		//get connection
		Connection con = obju.getConnection();
		
		//Execute Statement
		Statement stmt= null;
		try {
		 stmt= con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//get data
		try {
			ResultSet rs = stmt.executeQuery("select * from Category");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Category obj = new Category(id,name);
				result.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return result;
	}
	@Override
	public Set<Problem> getProblemFromDB() {
		Set <Problem> result = new HashSet<>();
		//get connection
		Connection con = obju.getConnection();
		
		//Execute Statement
		Statement stmt= null;
		try {
		 stmt= con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//get data
		try {
			ResultSet rs = stmt.executeQuery("select * from Problem");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String des = rs.getString(3);
				Problem obj = new Problem(id,name,des);
				result.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return result;
	}
	@Override
	public void setSolutionInDB(Set<Solution> sol) {
		Connection con = obju.getConnection();
		
		//create quarry

		for (Solution solution : sol) {
			String 	quary="INSERT INTO Solution VALUES("+solution.getSolutionId()+",'"+solution.getSolutionDescription()+"');";
		
		
		//Execute Statement
			Statement stmt= null;
		try {
		 stmt= con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Execute quarry
		try {
			stmt.executeUpdate(quary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
		}
		
	}

}
