package net.voznjuk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import net.voznjuk.dao.InvoiceDao;
import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.models.Invoice;

public class InvoiceDatabaseDaoImpl implements InvoiceDao {
	
	private static final String INSERT_INV = "INSERT INTO invoice (status, created, comments) VALUES ( ?, ?, ?);";
	private static final String SELECT_PROD_BY_ID = "SELECT * FROM product WHERE id = ?;";
	private static final String SELECT_ALL_INVOICES = "SELECT * FROM product;";
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
	public long add(Invoice model) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		long key = 0;
		System.out.println("Invoice ADD procidure");
		
		try {
			connection = JDBCUtils.getConnection(); 
			preparedStatement = connection.prepareStatement(INSERT_INV, PreparedStatement.RETURN_GENERATED_KEYS);
					
			preparedStatement.setString(1, model.getStatus());
			preparedStatement.setString(3, model.getComments());
			preparedStatement.setTimestamp(2, Timestamp.from(model.getDate()));

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();

			if (rs.next()) {
			    key = rs.getLong(1);
			    System.out.println(key);
			}			
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
		return key;
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
