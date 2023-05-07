package com.spring.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.DatabaseConnection;
import com.spring.Dao.RegisterUserDao;
import com.spring.model.SetUserResponseModel;

public class RegisterUserDaoImpl implements RegisterUserDao {
	private static final String USER_NAME = DatabaseConnection.getUserName();
	private static final String PASSWORD = DatabaseConnection.getPassword();
	private static final String DB_URL = DatabaseConnection.getDbURL();
	private static final String DRIVER = DatabaseConnection.getDriver();
	private SetUserResponseModel serverResponse = null;
	private PreparedStatement preparedStatement;
	private static Connection connection;
	private String POSTQUERY = "INSERT INTO highwaytoirdatabase.usertable(user_email,user_username,user_password)VALUES(?,?,?)";

	private void configureDBConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SetUserResponseModel registerNewUser(String username, String email, String password) throws SQLException {
		int number_of_rows_affected = 0;
		try {
			this.configureDBConnection();
			this.preparedStatement = connection.prepareStatement(this.POSTQUERY);
			this.preparedStatement.setString(1, email);
			this.preparedStatement.setString(2, username);
			this.preparedStatement.setString(3, password);
			number_of_rows_affected = this.preparedStatement.executeUpdate();
			this.serverResponse = new SetUserResponseModel(number_of_rows_affected);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.preparedStatement.close();
			connection.close();

		}
		return this.serverResponse;
	}

}
