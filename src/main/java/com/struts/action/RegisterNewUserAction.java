package com.struts.action;

import java.sql.SQLException;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.managerImpl.ManagerImpl;
import com.spring.model.ErrorModel;
import com.spring.model.SetUserResponseModel;

public class RegisterNewUserAction {

	private String username;
	private String email;
	private String password;
	private SetUserResponseModel response = null;
	private String responseString = "success";
	private ErrorModel errorResponse;

//	application context
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//	ManageImpl bean 
	ManagerImpl manageImpl = context.getBean("managerImpl", ManagerImpl.class);

	public String getUsername() {
		return this.username;
	}

	public ManagerImpl getManageImpl() {
		return this.manageImpl;
	}

	public void setManageImpl(ManagerImpl manageImpl) {
		this.manageImpl = manageImpl;
	}

	@JSON(name = "username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	@JSON(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	@JSON(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	public SetUserResponseModel getResponse() {
		return this.response;
	}

	public void setResponse(SetUserResponseModel response) {
		this.response = response;
	}

	public String getResponseString() {
		return this.responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public String registerNewUser() throws SQLException {

//		managerImpl Method call 
		this.setResponse(manageImpl.registerNewUser(this.getUsername(), this.getEmail(), this.getPassword()));
		if (this.getResponse() == null) {
			this.setResponseString("error");
			this.setErrorResponse(new ErrorModel("Cannot put duplicate entry for primary key"));
		}
		return this.getResponseString();
	}

	public ErrorModel getErrorResponse() {
		return this.errorResponse;
	}

	public void setErrorResponse(ErrorModel errorResponse) {
		this.errorResponse = errorResponse;
	}
}
