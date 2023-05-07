package com.spring.managerImpl;

import java.sql.SQLException;
import java.util.List;

import com.spring.DaoImpl.GetAllUserDaoImpl;
import com.spring.DaoImpl.RegisterUserDaoImpl;
import com.spring.manager.ManagerInterface;
import com.spring.model.GetAllUserModel;
import com.spring.model.SetUserResponseModel;

public class ManagerImpl implements ManagerInterface {

	private GetAllUserDaoImpl getAllUserDaoImpl;
	private RegisterUserDaoImpl registerUserDaoImpl;

	public GetAllUserDaoImpl getGetAllUserDaoImpl() {
		return this.getAllUserDaoImpl;
	}

	public void setGetAllUserDaoImpl(GetAllUserDaoImpl getAllUserDaoImpl) {
		this.getAllUserDaoImpl = getAllUserDaoImpl;
	}

	public RegisterUserDaoImpl getRegisterUserDaoImpl() {
		return this.registerUserDaoImpl;
	}

	public void setRegisterUserDaoImpl(RegisterUserDaoImpl registerUserDaoImpl) {
		this.registerUserDaoImpl = registerUserDaoImpl;
	}

	@Override
	public List<GetAllUserModel> getAllUser() throws SQLException {
		return this.getGetAllUserDaoImpl().geAllUser();
	}

	@Override
	public SetUserResponseModel registerNewUser(String username, String email, String password) throws SQLException {
		return this.getRegisterUserDaoImpl().registerNewUser(username, email, password);
	}

}
