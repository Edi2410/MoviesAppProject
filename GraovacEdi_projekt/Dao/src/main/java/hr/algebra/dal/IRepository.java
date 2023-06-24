/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.dal.models.Movie;
import hr.algebra.dal.models.People;
import hr.algebra.dal.models.PeopleAndMovie;
import hr.algebra.dal.models.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author egraedi
 */
public interface IRepository {
    Optional<User> authUser(String username, String password) throws Exception;    
    int createUser(String username, String password) throws Exception;    
    int createPeople(String nameAndlastname) throws Exception;    
    Optional<User> getUser(int ID) throws Exception;    
    Optional<Movie> getMovie(int ID) throws Exception;    
    void deleteActors(int ID) throws Exception;       
    void deleteDirectors(int ID) throws Exception;       
    List<People> getMovieActors(int ID) throws Exception;    
    List<People> getMovieDirectors(int ID) throws Exception;    
    List<People> getPeoples() throws Exception;    
    List<Movie> getMovies() throws Exception;
    int saveMovie(Movie movie) throws Exception;    
    void updateMovie(Movie movie) throws Exception;
    int saveActors(int movieID, int userID)throws Exception;
    int saveDirectors(int movieID, int userID)throws Exception;    
    void deleteAll()throws Exception;
    void loadMovies(List<Movie> movies) throws Exception;

}

