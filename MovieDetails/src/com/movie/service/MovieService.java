package com.movie.service;

import java.util.Set;

import com.movie.entity.Actor;
import com.movie.entity.Movie;
import com.movie.entity.MovieActor;
import com.movie.exception.MovieServiceException;

public interface MovieService {

	public Set<Movie> getMovieFromDao() throws MovieServiceException;

	public Set<Actor> getActorFromDao() throws MovieServiceException;

	public Set<MovieActor> getMovieActorFromDao() throws MovieServiceException;

	public Set<Movie> getMoviesByActor(String s) throws MovieServiceException;

	public Set<Actor> getActorsByMovie(String s) throws MovieServiceException;

}
