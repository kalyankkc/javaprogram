package com.movie.entity;

public class MovieActor {
	private int movieId;
	private int actorId;

	public MovieActor() {
		super();
	}

	public MovieActor(int movieId, int actorId) {
		super();
		this.movieId = movieId;
		this.actorId = actorId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actorId;
		result = prime * result + movieId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieActor other = (MovieActor) obj;
		if (actorId != other.actorId)
			return false;
		if (movieId != other.movieId)
			return false;
		return true;
	}

}
