package net.voznjuk.dao.impl;

import java.util.List;

import net.voznjuk.dao.ProductDao;
import net.voznjuk.models.Product;

public class ProductDatabaseDaoImpl implements ProductDao {
	
	private static final String INSERT_PROD = "INSERT INTO employee (f_name, s_name, login, password, credentials_id) VALUES ( ?, ?, ?, ?, ?);";
	private static final String SELECT_PROD_BY_ID = "SELECT * FROM employee WHERE id = ?;";
	private static final String SELECT_PROD_BY_LOGIN = "SELECT * FROM employee WHERE login = ?;";
	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM employee;";
	private static final String UPDATE_PROD_BY_ID = "UPDATE employee SET f_name = ?, s_name = ?, login = ?, password = ?, credentials_id = ? WHERE id = ?;";
	private static final String DELETE_PROD_BY_ID = "DELETE FROM employee WHERE id = ?;";

	public ProductDatabaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Product model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product model) {
		// TODO Auto-generated method stub

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
	public boolean delById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
