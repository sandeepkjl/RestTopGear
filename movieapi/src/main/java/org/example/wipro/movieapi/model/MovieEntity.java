package org.example.wipro.movieapi.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieEntity {
	
	private String movieId;
	private String movieName;
	private String movieActor;
	private float movieCollection;
	
	public MovieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieEntity(String movieId, String movieName, String movieActor, float movieCollection) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieActor = movieActor;
		this.movieCollection = movieCollection;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieActor() {
		return movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	public float getMovieCollection() {
		return movieCollection;
	}

	public void setMovieCollection(float movieCollection) {
		this.movieCollection = movieCollection;
	}

	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", movieActor=" + movieActor
				+ ", movieCollection=" + movieCollection + "]";
	}
	

}
