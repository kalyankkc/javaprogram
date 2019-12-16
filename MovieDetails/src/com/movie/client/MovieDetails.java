package com.movie.client;

import java.util.Scanner;
import java.util.Set;

import com.movie.entity.Actor;
import com.movie.entity.Movie;
import com.movie.exception.MovieServiceException;
import com.movie.service.serviceimpl.MovieServiceImpl;

public class MovieDetails {
	static Scanner input = new Scanner(System.in);
	static MovieServiceImpl objs = new MovieServiceImpl();

	public static void main(String[] args) throws MovieServiceException {
		boolean chk = true;
		do {
			System.out.println("Enter 1 to see Movies by Actor name");
			System.out.println("Enter 2 to see Actors by Movie name");
			System.out.println("Enter 3 to exit");
			int n = input.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter Actor name");
				String a = input.next();
				Set<Movie> movies = objs.getMoviesByActor(a);
				for (Movie movie : movies) {
					System.out.println(movie.getMovName());
				}
				break;
			case 2:
				System.out.println("Enter Movie name");
				String m = input.next();
				Set<Actor> actors = objs.getActorsByMovie(m);
				for (Actor actor : actors) {
					System.out.println(actor.getActName());
				}
				break;
			case 3:
				chk = false;
				break;
			}

		} while (chk == true);

	}

}
