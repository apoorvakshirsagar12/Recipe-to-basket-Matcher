package com.recipes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.recipes.bean.LoginBean;
import com.recipes.util.DBConnection;

public class LoginDao {
	
	public String authenticateUser(LoginBean user)
	{
		String userName = user.getEmail(); // Keeping user entered values in temporary variables.
		String password = user.getPassword();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String userNameDB = "";
		String passwordDB = "";
		try {
			con = DBConnection.createConnection(); // establishing connection
			System.out.println(con);
			String sql = "select * from user_tbl where user_email = '" + userName + "' and user_passwd = '" + password + "'" ;
			System.out.println(sql);
			statement = con.createStatement(); // Statement is used to write queries. Read more about it.
			resultSet = statement.executeQuery(sql); // Here table name is users and userName,password are columns.
														// fetching all the records and storing in a resultSet.
			while (resultSet.next()) // Until next row is present otherwise it return false
			{
				userNameDB = resultSet.getString("user_email"); // fetch the values present in database
				passwordDB = resultSet.getString("user_passwd");
				System.out.println(userNameDB + " " + passwordDB);
				if (userName.equals(userNameDB) && password.equals(passwordDB)) {
					return "SUCCESS"; //// If the user entered values are already present in database, which means
										//// user has already registered so I will return SUCCESS message.
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials"; // Just returning appropriate message otherwise
	}

}
