package com.spring.Dao;

import java.sql.SQLException;

import com.spring.model.SetUserResponseModel;

public interface RegisterUserDao {
	public SetUserResponseModel registerNewUser(String username, String email, String password) throws SQLException;
}
