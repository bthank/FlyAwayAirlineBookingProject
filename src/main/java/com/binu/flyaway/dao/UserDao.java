package com.binu.flyaway.dao;

import java.sql.SQLException;

import com.binu.flyaway.dto.User;

public interface UserDao {

	void connect() throws SQLException;
	void disconnect() throws SQLException;
	boolean validateAdminUser(User user) throws SQLException;
	User findUser(String username, String password) throws SQLException;
}
