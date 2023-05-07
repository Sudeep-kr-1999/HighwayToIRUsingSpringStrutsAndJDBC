package com.struts.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.managerImpl.ManagerImpl;
import com.spring.model.ErrorModel;
import com.spring.model.GetAllUserModel;

public class GetRegisteredUserAction {

	private List<GetAllUserModel> data = new ArrayList<GetAllUserModel>();
	private String resultStatus = "success";
	private ErrorModel errorResponse;

//	applicationContext
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//	managerImplBean 
	private ManagerImpl managerImpl = context.getBean("managerImpl", ManagerImpl.class);

	public ManagerImpl getManagerImpl() {
		return this.managerImpl;
	}

	public void setManagerImpl(ManagerImpl managerImpl) {
		this.managerImpl = managerImpl;
	}

	public List<GetAllUserModel> getData() {
		return this.data;
	}

	public void setData(List<GetAllUserModel> userList) {
		this.data = userList;
	}

	public String getAllRegisterUser() throws SQLException {

//		managerImplMethodCall
		this.setData(this.managerImpl.getAllUser());
		if (this.getData() == null) {
			this.setResultStatus("error");
			this.setErrorResponse(new ErrorModel("SOME ERROR OCCURED"));
		}
		return this.getResultStatus();
	}

	public String getResultStatus() {
		return this.resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public ErrorModel getErrorResponse() {
		return this.errorResponse;
	}

	public void setErrorResponse(ErrorModel errorResponse) {
		this.errorResponse = errorResponse;
	}

}
