package net.voznjuk.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.dao.ProductToInvoiceDao;
import net.voznjuk.models.Invoice;

public class ProdToInvDatabaseDaoImpl implements ProductToInvoiceDao {
	
	private static final String INSERT_INV = "INSERT INTO invoice (status, created, comments) VALUES ( ?, ?, ?);";
	private static final String SELECT_LINES_BY_INV_ID = "SELECT * FROM invoice_has_product WHERE invoice_id = ?;";
	private static final String SELECT_ALL_INVOICES = "SELECT * FROM invoice;";
	private static final String UPDATE_PROD_BY_ID = "UPDATE product SET name = ?, description = ?, stock = ?, price = ?, product_status_id = ? WHERE id = ?;";
	private static final String DELETE_PROD_BY_ID = "DELETE FROM product WHERE id = ?;";
	private static final String GET_INVOICE_SUM = "SELECT SUM(quantity * price) FROM invoice_has_product WHERE invoice_id = 11;";

	@Override
	public int getProductsByInvoiceId(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProductToInvoice(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delProductFromInvoiceById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updProductInInvoiceById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getInvoiceSum(Long id) {
		
		float invoiceSum = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(GET_INVOICE_SUM);
			preparedStatement.setLong(1, id);
			//System.out.println(preparedStatement.toString());
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				invoiceSum = rs.getFloat(1);
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
		return invoiceSum;
	}

}
