package com.recipes.util;

import java.sql.Connection;

public class DBConnection {
	public static String SERVER = "localhost";
	public static int PORT = 3306;
	public static String DB = "recipe_matcher";
	public static String USER = "root";
	public static String PASSWORD = "root";
	public Connection connection;

	public static Connection createConnection()
	{
		Connection connection = null;
			try 
			{
				com.mysql.jdbc.jdbc2.optional.MysqlDataSource db = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
				db.setServerName(SERVER);
				db.setPort(PORT);
				db.setDatabaseName(DB);
				db.setUser(USER);
				db.setPassword(PASSWORD);

				connection = db.getConnection();
				
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			} 
			return connection;
	}
}
