package com.spring.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.DatabaseConnection;
import com.spring.Dao.GetAllUserDao;
import com.spring.model.GetAllUserModel;

public class GetAllUserDaoImpl implements GetAllUserDao {
	private static final String USER_NAME = DatabaseConnection.getUserName();
	private static final String PASSWORD = DatabaseConnection.getPassword();
	private static final String DB_URL = DatabaseConnection.getDbURL();
	private static final String DRIVER = DatabaseConnection.getDriver();
	private List<GetAllUserModel> registeredUser = new ArrayList<GetAllUserModel>();
	private static Connection connection;
	private Statement statement;
	private ResultSet rs;
	private String QUERY = "SELECT * FROM highwaytoirdatabase.usertable";

	private void configureDbConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<GetAllUserModel> geAllUser() throws SQLException {
		try {
			this.configureDbConnection();
			this.statement = connection.createStatement();
			this.rs = this.statement.executeQuery(this.QUERY);
			while (rs.next()) {
				GetAllUserModel user = new GetAllUserModel(rs.getString("user_email"), rs.getString("user_username"));
				this.registeredUser.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.statement.close();
			connection.close();

		}
		return this.registeredUser;

	}
}
