package org.example.wipro.movieapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.wipro.movieapi.model.MovieEntity;

public class MovieRepository {
	
	static List<MovieEntity> movieEntities;
	
	static{
		
		movieEntities=new ArrayList<MovieEntity>();
		
		movieEntities.add(new MovieEntity("movie101", "Veer Jara", "Shahrukh Khan" , 500000000.00f));
		movieEntities.add(new MovieEntity("movie102", "Khiladi", "Akshay Kumar" , 300000000.00f));
		movieEntities.add(new MovieEntity("movie103", "Tiranga", "Raj Kumar" , 200000000.00f));
		movieEntities.add(new MovieEntity("movie104", "Pramanu", "John Abhraham" , 600000000.00f));
		movieEntities.add(new MovieEntity("movie105", "Janwar", "Akshay Kumar" , 200000000.00f));
		movieEntities.add(new MovieEntity("movie106", "Deewana", "Shahrukh Khan" , 300000000.00f));
		movieEntities.add(new MovieEntity("movie107", "Ghayal", "Sunny Deol" , 150000000.00f));
		movieEntities.add(new MovieEntity("movie108", "Rang De Basanti", "Amir Khan" , 700000000.00f));
		movieEntities.add(new MovieEntity("movie109", "Wanted", "Salaman Khan" , 900000000.00f));
		movieEntities.add(new MovieEntity("movie110", "Danagal", "Amir Khan" , 3000000000.00f));
		
	}
	
	public static List<MovieEntity> getAllMovies()
	{
		return movieEntities;
	}
	
	public static MovieEntity getMovieById(String id)
	{
		for(MovieEntity  e: movieEntities)
		{
			if(e.getMovieId().equals(id))
			{
				return e;
			}
			
		}
		
		return null;
	}
	

}
