package org.example.wipro.movieapi;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.example.wipro.movieapi.model.MovieEntity;
import org.example.wipro.movieapi.repository.MovieRepository;


@Path("movieresource")
public class MovieResource {
	
    // “GET” method that returns all the movie objects in “text/xml” format
	//endpoint:- http://localhost:9090/movieapi/webapi/movieresource/TextXMLResponse
    @GET
    @Path("/TextXMLResponse")
    @Produces(MediaType.TEXT_XML)
    public List<MovieEntity> getAllMovieInTextXML() {
        return MovieRepository.getAllMovies();
    }
    
    
    //“GET” method that returns all the movie objects in “application/xml” format
    //endpoint:- http://localhost:9090/movieapi/webapi/movieresource/XMLResponse
    @GET
    @Path("/XMLResponse")
    @Produces(MediaType.APPLICATION_XML)
    public List<MovieEntity> getAllMovieInXML() {
        return MovieRepository.getAllMovies();
    }
    
    
    // “GET” method that returns all the movie objects in “application/json” format
    //endpoint:-http://localhost:9090/movieapi/webapi/movieresource/JSONResponse
    @GET
    @Path("/JSONResponse")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovieEntity> getAllMovieInJSON() {
        return MovieRepository.getAllMovies();
    }
    
    
    //“GET” method that takes a “movieId” and return that movie
    //endpoint:-http://localhost:9090/movieapi/webapi/movieresource/XMLResponseByMovieId/{movieIdValue}
    @GET
    @Path("/XMLResponseByMovieId/{movieId}")
    @Produces(MediaType.APPLICATION_XML)
    public MovieEntity getMovieByID(@PathParam(value = "movieId") String Id) {
        return MovieRepository.getMovieById(Id);
    }
    
    
}
