package com.spring.Dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.model.GetAllUserModel;

public interface GetAllUserDao {
	public List<GetAllUserModel> geAllUser() throws SQLException;
}
