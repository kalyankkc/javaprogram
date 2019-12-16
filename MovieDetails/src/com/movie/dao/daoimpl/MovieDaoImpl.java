package com.movie.dao.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.movie.dao.MovieDao;
import com.movie.entity.Actor;
import com.movie.entity.Movie;
import com.movie.entity.MovieActor;
import com.movie.exception.MovieDaoException;
import com.movie.utility.MovieUtil;

public class MovieDaoImpl implements MovieDao {
	static MovieUtil obju = new MovieUtil();
	static Connection con = null;
	static Statement stmt = null;

	@Override
	public Set<Movie> getMovieFromDB() throws MovieDaoException {
		Set<Movie> res = new HashSet<>();
		// get connection
		try {
			con = obju.getConnection();
		} catch (MovieDaoException e) {
			throw new MovieDaoException(e);
		}
		// get statement
		try {
			stmt = con.createStatement();
			// get data
			ResultSet rs = stmt.executeQuery("select * from Movie;");
			while (rs.next()) {
				Movie obje = new Movie();
				obje.setMovId(rs.getInt(1));
				obje.setMovName(rs.getString(2));
				obje.setBudget(rs.getInt(3));
				res.add(obje);

			}
		} catch (SQLException e) {
			throw new MovieDaoException(e);
		}

		// close
		finally {
			close();
		}

		return res;
	}

	@Override
	public Set<Actor> getActorFromDB() throws MovieDaoException {
		Set<Actor> res = new HashSet<>();
		// get connection
		try {
			con = obju.getConnection();
		} catch (MovieDaoException e) {
			throw new MovieDaoException(e);
		}
		// get statement
		try {
			stmt = con.createStatement();
			// get data
			ResultSet rs = stmt.executeQuery("select * from Actor;");
			while (rs.next()) {
				Actor obje = new Actor();
				obje.setActId(rs.getInt(1));
				obje.setActName(rs.getString(2));
				res.add(obje);
			}
		} catch (SQLException e) {
			throw new MovieDaoException(e);
		}

		// close
		finally {
			close();
		}

		return res;
	}

	@Override
	public Set<MovieActor> getMovieActorFromDB() throws MovieDaoException {
		Set<MovieActor> res = new HashSet<>();
		// get connection
		try {
			con = obju.getConnection();
		} catch (MovieDaoException e) {
			throw new MovieDaoException(e);
		}
		// get statement
		try {
			stmt = con.createStatement();
			// get data
			ResultSet rs = stmt.executeQuery("select * from MovieActor;");
			while (rs.next()) {
				MovieActor obje = new MovieActor();
				obje.setActorId(rs.getInt(1));
				obje.setMovieId(rs.getInt(2));
				res.add(obje);
			}
		} catch (SQLException e) {
			throw new MovieDaoException(e);
		}

		// close
		finally {
			close();
		}
		return res;
	}

	private void close() throws MovieDaoException {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new MovieDaoException(e);

		}
	}

}
