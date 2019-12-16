package com.movie.dao;

import java.util.Set;

import com.movie.entity.Actor;
import com.movie.entity.Movie;
import com.movie.entity.MovieActor;
import com.movie.exception.MovieDaoException;

public interface MovieDao {

	public Set<Movie> getMovieFromDB() throws MovieDaoException;

	public Set<Actor> getActorFromDB() throws MovieDaoException;

	public Set<MovieActor> getMovieActorFromDB() throws MovieDaoException;

}
