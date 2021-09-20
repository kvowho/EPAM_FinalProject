package net.voznjuk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.voznjuk.dao.ProductDao;
import net.voznjuk.models.Product;
import net.voznjuk.dao.JDBCUtils;

public class ProductDatabaseDaoImpl implements ProductDao {
	
	private static final String INSERT_PROD = "INSERT INTO product (name, description, stock, price, product_status_id) VALUES ( ?, ?, ?, ?, ?);";
	private static final String SELECT_PROD_BY_ID = "SELECT * FROM product WHERE id = ?;";
	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product WHERE (id LIKE ? or name LIKE ? or description LIKE ?) LIMIT ?, ?;";
	private static final String UPDATE_PROD_BY_ID = "UPDATE product SET name = ?, description = ?, stock = ?, price = ?, product_status_id = ? WHERE id = ?;";
	private static final String DELETE_PROD_BY_ID = "DELETE FROM product WHERE id = ?;";
	private static final String SEARCH_PROD_BY_KEY = "SELECT * FROM product;";

	public ProductDatabaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product getById(Long id) {
		Product product = new Product();
		System.out.println(" **** getById mothod ****");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_PROD_BY_ID);
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement.toString());
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				product = new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getFloat(5), rs.getInt(6));
			}			
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
		return product;
	}

	@Override
	public List<Product> getAll(int start, int ofset, String searchKey) {
		List<Product> products = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		//searchKey = "very";
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
			preparedStatement.setString(1, searchKey);
			preparedStatement.setString(2, searchKey);
			preparedStatement.setString(3, searchKey);
			preparedStatement.setInt(4, start);
			preparedStatement.setInt(5, ofset);
			System.out.println(preparedStatement.toString());
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				products.add(new Product( rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getFloat(5), rs.getInt(6)) );				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace(System.out);
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
		//System.out.println(products.size());
		return products;
	}

	@Override
	public long add(Product model) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JDBCUtils.getConnection(); 
			preparedStatement = connection.prepareStatement(INSERT_PROD);
					
			preparedStatement.setString(1, model.getName());
			preparedStatement.setString(2, model.getDescription());
			preparedStatement.setLong(3, model.getStockQuantity());
			preparedStatement.setFloat(4, model.getPrice());
			preparedStatement.setInt(5, model.getAvailabilityStatus());
			preparedStatement.execute();
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void update(Product model) {
		System.out.println(" **** updById mothod ****");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_PROD_BY_ID);
			preparedStatement.setString(1, model.getName());
			preparedStatement.setString(2, model.getDescription());
			preparedStatement.setLong(3, model.getStockQuantity());
			preparedStatement.setFloat(4, model.getPrice());
			preparedStatement.setInt(5, model.getAvailabilityStatus());
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
	public void delete(Product model) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getByName(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delById(Long id) {
		System.out.println(" **** delById mothod ****");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_PROD_BY_ID);
			preparedStatement.setLong(1, id);
			rs = preparedStatement.executeUpdate();
			//System.out.println(rs);
			
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
		return rs;
	}

	@Override
	public List<Product> searchListByKey(String key) {
		List<Product> products = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SEARCH_PROD_BY_KEY);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				products.add(new Product( rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getFloat(5), rs.getInt(6)) );				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace(System.out);
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
		//System.out.println(products.size());
		return products;
	}
	


}
