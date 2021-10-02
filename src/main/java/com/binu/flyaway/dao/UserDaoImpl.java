package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.binu.flyaway.dto.Flight;
import com.binu.flyaway.dto.TravelSearchDetail;
import com.binu.flyaway.dto.User;

/**
 * UserDaoImpl.java
 * This is the class containing CRUD implementations of the data access methods listed in the UserDao interface
 *  
 */
public class UserDaoImpl implements UserDao {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	
	public UserDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		
        
        System.out.println("In UserDaoImpl constructor   jdbcURL= " + jdbcURL);
        System.out.println("In UserDaoImpl constructor   jdbcUsername= " + jdbcUsername);
        System.out.println("In UserDaoImpl constructor   jdbcPassword= " + jdbcPassword);
        

	}

	@Override
	public void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }		 
		
	}

	@Override
	public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }		 
		
	}


	@Override
	public boolean validateAdminUser(User user) throws SQLException {
		
		boolean isUserValid = false;
		
		String uname = user.getUsername();
		String pwd = user.getPassword();
		
		// Here we need to goto the database and retrieve info to compare against user's input
		User foundUser = findUser(uname, pwd);
		
		if (foundUser != null) {
			return isUserValid = true;
		}
		
		System.out.println("In UserDaoImpl  isUserValid= " + isUserValid);
		return isUserValid;
	}


	@Override
	public User findUserByUsername(String username) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE username = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);
 
        
        ResultSet resultSet = statement.executeQuery();
         
        while (resultSet.next()) {
            String usrname = resultSet.getString("username");
            String pwd = resultSet.getString("password");
               
            user = new User(usrname, pwd);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
	}

	@Override
	public User findUser(String username, String password) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
  
        
        ResultSet resultSet = statement.executeQuery();
         
        while (resultSet.next()) {
            String usrname = resultSet.getString("username");
            String pwd = resultSet.getString("password");
               
            user = new User(usrname, pwd);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
	}

	@Override
	public boolean updateUserPassword(User user) throws SQLException {
		 
        String sql = "UPDATE user SET password = ? WHERE username = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getPassword());
        statement.setString(2, user.getUsername());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     		
		
	}

}
