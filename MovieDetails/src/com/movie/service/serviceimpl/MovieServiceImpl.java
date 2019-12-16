package com.movie.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.movie.dao.daoimpl.MovieDaoImpl;
import com.movie.entity.Actor;
import com.movie.entity.Movie;
import com.movie.entity.MovieActor;
import com.movie.exception.MovieDaoException;
import com.movie.exception.MovieServiceException;
import com.movie.service.MovieService;

public class MovieServiceImpl implements MovieService {
	static MovieDaoImpl objd = new MovieDaoImpl();

	@Override
	public Set<Movie> getMovieFromDao() throws MovieServiceException {
		Set<Movie> movies = new HashSet<>();
		try {
			movies = objd.getMovieFromDB();
		} catch (MovieDaoException e) {
			throw new MovieServiceException(e);
		}

		return movies;
	}

	@Override
	public Set<Actor> getActorFromDao() throws MovieServiceException {
		Set<Actor> actors = new HashSet<>();
		try {
			actors = objd.getActorFromDB();
		} catch (MovieDaoException e) {
			throw new MovieServiceException(e);
		}
		return actors;
	}

	@Override
	public Set<MovieActor> getMovieActorFromDao() throws MovieServiceException {
		Set<MovieActor> maId = new HashSet<>();
		try {
			maId = objd.getMovieActorFromDB();
		} catch (MovieDaoException e) {
			throw new MovieServiceException(e);
		}
		return maId;
	}

	@Override
	public Set<Movie> getMoviesByActor(String s) throws MovieServiceException {
		Set<Movie> res = new HashSet<>();
		int actId = 0;
		List<Integer> movId = new ArrayList<>();
		Set<Actor> actors = getActorFromDao();
		Set<Movie> movies = getMovieFromDao();
		Set<MovieActor> maIds = getMovieActorFromDao();
		for (Actor actor : actors) {
			if (s.equals(actor.getActName())) {
				actId = actor.getActId();
			}
		}
		for (MovieActor movieActor : maIds) {
			if (actId == movieActor.getActorId()) {
				movId.add(movieActor.getMovieId());
			}
		}
		for (Movie movie : movies) {
			for (int id : movId) {
				if (movie.getMovId() == id) {
					res.add(movie);
				}
			}
		}

		return res;
	}

	@Override
	public Set<Actor> getActorsByMovie(String s) throws MovieServiceException {
		Set<Actor> res = new HashSet<>();
		int movId = 0;
		List<Integer> actId = new ArrayList<>();
		Set<Actor> actors = getActorFromDao();
		Set<Movie> movies = getMovieFromDao();
		Set<MovieActor> maIds = getMovieActorFromDao();
		for (Movie movie : movies) {
			if (s.equals(movie.getMovName())) {
				movId = movie.getMovId();
			}
		}
		for (MovieActor movieActor : maIds) {
			if (movId == movieActor.getMovieId()) {
				actId.add(movieActor.getActorId());
			}
		}
		for (Actor actor : actors) {
			for (int id : actId) {
				if (actor.getActId() == id) {
					res.add(actor);
				}
			}
		}

		return res;
	}

}
