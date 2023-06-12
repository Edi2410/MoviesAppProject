/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.dal.models.People;
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
    List<People> getPeoples() throws Exception;



}
