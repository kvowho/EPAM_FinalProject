package net.voznjuk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import net.voznjuk.dao.InvoiceLineDao;
import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.models.Invoice;
import net.voznjuk.models.InvoiceLine;
import net.voznjuk.models.InvoiceLineKey;
import net.voznjuk.models.Product;
import net.voznjuk.ui.InvoiceCommand;

public class InvoiceLineDatabaseDaoImpl implements InvoiceLineDao {
	
	final static Logger logger = Logger.getLogger(InvoiceCommand.class);
	
	private static final String INSERT_INV = "INSERT INTO invoice (status, created, comments) VALUES ( ?, ?, ?);";
	private static final String SELECT_INV_BY_ID = "SELECT * FROM invoice WHERE id = ?;";
	private static final String SELECT_ALL_LINES_BY_INV = "SELECT  p.*, l.* FROM invoice_has_product l JOIN product p ON l.product_id = p.id WHERE l.invoice_id = ?;";
	private static final String UPDATE_PROD_BY_ID = "UPDATE product SET name = ?, description = ?, stock = ?, price = ?, product_status_id = ? WHERE id = ?;";
	private static final String DELETE_PROD_BY_ID = "DELETE FROM product WHERE id = ?;";


	@Override
	public List<InvoiceLine> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long add(InvoiceLine model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(InvoiceLine model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InvoiceLine model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InvoiceLine> getLinesByInvoice(Invoice model) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("ILDDAO lines for invoice : " + model.getId() + " has been requested");
		}

		List<InvoiceLine> lines = new ArrayList<>();
		// InvoiceLine invoiceLine = null;
		InvoiceLineKey invoiceLineKey = null;
		// Invoice invoice = null;
		Product product = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_LINES_BY_INV);
			preparedStatement.setLong(1, model.getId());
			if (logger.isDebugEnabled()) {
				logger.debug("ILDDAO request for the invoice lines" + preparedStatement.toString());
			}
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				invoiceLineKey = new InvoiceLineKey(rs.getLong(7), rs.getLong(8));
				product = new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getFloat(5), rs.getInt(6));
				lines.add(new InvoiceLine( invoiceLineKey, model, product, rs.getFloat(10), rs.getLong(9)));				
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
		return lines;
	}

}
