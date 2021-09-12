package net.voznjuk.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.models.User;

public class test_res {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ResourceBundle bundleDefault = ResourceBundle.getBundle("resources");
//		System.out.println(bundleDefault.getString("somemess"));
//		String page = ConfigurationManager.getProperty("path.page.main");
//		System.out.println(page);

		
		
//		final String SELECT_USER_BY_LOGIN = "SELECT * FROM employee WHERE login = ?;";
//		String login = "ivan";
//				
//		User user = new User();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//		
//		try {
//			connection = JDBCUtils.getConnection();
//			preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
////			preparedStatement.setString(1, "ivan");
////			System.out.println(preparedStatement.toString());
////			rs = preparedStatement.executeQuery();
////			user = new User(rs.getLong("id"), rs.getString("f_name"), rs.getString("s_name"), rs.getString("login"), rs.getString("password"), rs.getString("credentials_id"));
////			System.out.println(user.toString());
//			//preparedStatement = connection.prepareStatement("select * from employee where login = ? and password = ? ");
//				preparedStatement.setString(1, "ivan");
//				//preparedStatement.setString(2, "first");
//
//				System.out.println(preparedStatement);
//				rs = preparedStatement.executeQuery();
//				boolean status = rs.next();
//				System.out.println(status);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				preparedStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
		final String DELETE_USER_BY_ID = "DELETE FROM employee WHERE id = ?;";
		
		
		System.out.println(" **** delById mothod ****");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		//boolean status = false;
		Long id = (long) 7;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
			preparedStatement.setLong(1, id);
			rs = preparedStatement.executeUpdate();
			System.out.println(rs);
			//status = true;
			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//rs.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}

}
