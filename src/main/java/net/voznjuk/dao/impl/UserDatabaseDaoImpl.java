package net.voznjuk.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.dao.UserDao;
import net.voznjuk.models.User;

public class UserDatabaseDaoImpl implements UserDao{
	
	private String jdbcURL = "jdbc:mysql://193.123.66.4:3306/Cashbox?useSSL=false";
	private String jdbcUser = "webuser";
	private String jdbcPassword = "Voz!1972";
	
	private static final String INSERT_USER = "INSERT INTO employee (f_name, s_name, login, password, credentials_id) VALUES ( ?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM employee WHERE id = ?;";
	private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM employee WHERE login = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM employee;";
	private static final String UPDATE_USER_BY_ID = "UPDATE employee SET f_name = ?, s_name = ?, login = ?, password = ?, credentials_id = ? WHERE id = ?;";
	private static final String DELETE_USER_BY_ID = "DELETE FROM employee WHERE id = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	} 
	
	public UserDatabaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getById(Long id) {
		User user = new User();
		System.out.println(" **** getById mothod ****");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement.toString());
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				user = new User(rs.getLong("id"), rs.getString("f_name"), rs.getString("s_name"), rs.getString("login"), rs.getString("password"), rs.getString("credentials_id"));
			}
			
//			System.out.println(user.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		
		try ( Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				//System.out.println(rs.getString(3));
				users.add(new User(rs.getLong("id"), rs.getString("f_name"), rs.getString("s_name"), rs.getString("login"), rs.getString("password"), rs.getString("credentials_id")) );				
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return users;
	}

	@Override
	public void add(User model) {
		try( Connection connection = getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
			preparedStatement.setString(1, model.getFirstname());
			preparedStatement.setString(2, model.getLastname());
			preparedStatement.setString(3, model.getLogin());
			preparedStatement.setString(4, model.getPassword());
			preparedStatement.setString(5, model.getRole());
			preparedStatement.execute();
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}		
	}

	@Override
	public void update(User model) {
		
		System.out.println(" **** updById mothod ****");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
			preparedStatement.setString(1, model.getFirstname());
			preparedStatement.setString(2, model.getLastname());
			preparedStatement.setString(3, model.getLogin());
			preparedStatement.setString(4, model.getPassword());
			preparedStatement.setString(5, model.getRole());
			preparedStatement.setLong(6, model.getId());
			rs = preparedStatement.executeUpdate();
			System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}

	@Override
	public void delete(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByLogin(String login) {
		User user = new User();
		//System.out.println(" **** getByLogin mothod ****");
		
		//boolean status = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
			preparedStatement.setString(1, login);
			System.out.println(preparedStatement.toString());
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				user = new User(rs.getLong("id"), rs.getString("f_name"), rs.getString("s_name"), rs.getString("login"), rs.getString("password"), rs.getString("credentials_id"));
			}
			
//			System.out.println(user.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
//		try (connection = DriverManager.getConnection("jdbc:mysql://193.123.66.4:3306/Cashbox?useSSL=false", "webuser", "Voz!1972");
//
//				// Step 2:Create a statement using connection object
//			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where login = ?")) {
//			preparedStatement.setString(1, login);
//			System.out.println(preparedStatement.toString());
//			ResultSet rs = preparedStatement.executeQuery();
//			status = rs.next();
//			System.out.println("Request Status" + status);
//			user = new User(rs.getLong("id"), rs.getString("f_name"), rs.getString("s_name"), rs.getString("login"), rs.getString("password"), rs.getString("credentials_id"));
//			
//			rs.close();
//			preparedStatement.close();
//			connection.close();
//			
//
//		} catch (SQLException e) {
//			// process sql exception
//			//printSQLException(e);
//		} finally {
//		
//		}
		
		
		
		
		
//		try ( Connection connection = getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);){
//			preparedStatement.setString(1, login);
//			System.out.println("Prepared Statement = " + preparedStatement.toString());
//			ResultSet rs = preparedStatement.executeQuery();
//			
//			user = new User(rs.getLong("id"), rs.getString("f_name"), rs.getString("s_name"), rs.getString("login"), rs.getString("password"), rs.getString("credentials_id"));
//			System.out.println(user.toString());
//						
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			rs.close();
//			preparedStatement.close();
//			connection.close()
//		}		
		return user;
	}

	@Override
	public boolean delById(Long id) {
		
		System.out.println(" **** delById mothod ****");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs;
		boolean status = false;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
			preparedStatement.setLong(1, id);
			rs = preparedStatement.executeUpdate();
			System.out.println(rs);
			status = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}			
		return status;
	}

}
