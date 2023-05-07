package com.spring.manager;

import java.sql.SQLException;
import java.util.List;

import com.spring.model.GetAllUserModel;
import com.spring.model.SetUserResponseModel;

public interface ManagerInterface {
	public List<GetAllUserModel> getAllUser() throws SQLException;

	public SetUserResponseModel registerNewUser(String usrname, String email, String password) throws SQLException;
}
