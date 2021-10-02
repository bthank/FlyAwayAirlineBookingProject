package com.binu.flyaway.dao;

import java.sql.SQLException;

import com.binu.flyaway.dto.User;

/**
 * UserDao.java
 * This is the interface representing the available data access methods for the User class
 *  
 */
public interface UserDao {

	void connect() throws SQLException;
	void disconnect() throws SQLException;
	boolean validateAdminUser(User user) throws SQLException;
	User findUserByUsername(String username) throws SQLException;
	User findUser(String username, String password) throws SQLException;
	boolean updateUserPassword(User user) throws SQLException;
}
