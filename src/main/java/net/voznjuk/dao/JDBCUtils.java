package net.voznjuk.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	
	private static String jdbcURL = "jdbc:mysql://193.123.66.4:3306/Cashbox?useSSL=false";
	private static String jdbcUser = "webuser";
	private static String jdbcPassword = "Voz!1972";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
