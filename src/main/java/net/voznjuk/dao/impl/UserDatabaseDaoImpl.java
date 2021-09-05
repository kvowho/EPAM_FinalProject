package net.voznjuk.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.voznjuk.dao.UserDao;
import net.voznjuk.models.User;

public class UserDatabaseDaoImpl implements UserDao{
	
	private String jdbcURL = "jdbc:mysql://193.123.66.4:3306/Cashbox?useSSL=false";
	private String jdbcUser = "webuser";
	private String jdbcPassword = "Voz!1972";
	
	private static final String INSERT_USER = "INSERT INTO employee (f_name, s_name, login, password, credentials_id) VALUES ( '?', '?', '?', '?', ?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM employee WHERE id = ?;";
	private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM employee WHERE login = '?';";
	private static final String SELECT_ALL_USERS = "SELECT * FROM employee;";
	private static final String UPDATE_USER_BY_ID = "UPDATE employee SET f_name = '?', s_name = '?', login = '?', password = '?', credentials_id = '?' WHERE id = '?';";
	private static final String DELETE_USER_BY_ID = "DELETE FROM employee WHERE id = '?';";
	
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
