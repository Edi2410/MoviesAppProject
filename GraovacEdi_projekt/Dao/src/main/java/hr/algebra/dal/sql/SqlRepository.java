/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.IRepository;
import hr.algebra.dal.models.People;
import hr.algebra.dal.models.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author egraedi
 */
public class SqlRepository implements IRepository {

    private static final String IDUSER = "IDUser";
    private static final String USERNAME = "username";
    private static final String PASSWORDS = "passwords";
    private static final String ADMINISTRATOR = "administrator";

    private static final String PEOPLE_NAMES = "names";
    private static final String IDPEOPLE = "IDUserForMovies";

    private static final String AUTH_USER = "{ CALL authUser (?,?) }";
    private static final String CREATE_USER = "{ CALL createUser (?,?,?) }";
    private static final String SELECT_USER = "{ CALL selectUser (?) }";
    private static final String CREATE_PEOPLE = "{ CALL createPeople (?,?) }";
    private static final String SELECT_PEOPLE = "{ CALL selectPeople }";

    @Override
    public Optional<User> authUser(String username, String password) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(AUTH_USER);) {
            stmt.setString(USERNAME, username);
            stmt.setString(PASSWORDS, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(IDUSER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORDS),
                            rs.getString(ADMINISTRATOR)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public int createUser(String username, String password) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER);) {
            stmt.setString(USERNAME, username);
            stmt.setString(PASSWORDS, password);
            stmt.registerOutParameter(IDUSER, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(IDUSER);
        }
    }

    @Override
    public Optional<User> getUser(int ID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER);) {

            stmt.setInt(IDUSER, ID);

            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(IDUSER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORDS),
                            rs.getString(ADMINISTRATOR)
                    ));

                }
            }

        }
        return Optional.empty();
    }

    @Override
    public int createPeople(String nameAndlastname) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_PEOPLE);) {
            stmt.setString(PEOPLE_NAMES, nameAndlastname);
            stmt.registerOutParameter(IDPEOPLE, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(IDPEOPLE);
        }
    }

    @Override
    public List<People> getPeoples() throws Exception {
        List<People> peoples = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_PEOPLE); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                peoples.add(new People(
                        rs.getInt(IDPEOPLE),
                        rs.getString(PEOPLE_NAMES)));
            }
        }
        return peoples;
    }
}
