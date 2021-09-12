package net.voznjuk.dao.impl;

import java.util.List;

import net.voznjuk.dao.InvoiceDao;
import net.voznjuk.models.Invoice;

public class InvoiceDatabaseDaoImpl implements InvoiceDao {
	
	private static final String INSERT_PROD = "INSERT INTO product (name, description, stock, price, product_status_id) VALUES ( ?, ?, ?, ?, ?);";
	private static final String SELECT_PROD_BY_ID = "SELECT * FROM product WHERE id = ?;";
	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product;";
	private static final String UPDATE_PROD_BY_ID = "UPDATE product SET name = ?, description = ?, stock = ?, price = ?, product_status_id = ? WHERE id = ?;";
	private static final String DELETE_PROD_BY_ID = "DELETE FROM product WHERE id = ?;";

	public InvoiceDatabaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Invoice getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invoice> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Invoice model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Invoice model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Invoice model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int delById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
