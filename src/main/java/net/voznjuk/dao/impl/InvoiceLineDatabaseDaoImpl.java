package net.voznjuk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import net.voznjuk.dao.InvoiceDao;
import net.voznjuk.dao.InvoiceLineDao;
import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.dao.ProductDao;
import net.voznjuk.models.Invoice;
import net.voznjuk.models.InvoiceLine;
import net.voznjuk.models.InvoiceLineKey;
import net.voznjuk.models.Product;
import net.voznjuk.ui.InvoiceCommand;

public class InvoiceLineDatabaseDaoImpl implements InvoiceLineDao {
	
	final static Logger logger = Logger.getLogger(InvoiceCommand.class);
	
	private static final String INSERT_INVOICE_LINE = "INSERT INTO invoice_has_product (invoice_id, product_id, quantity, price) VALUES (?, ?, ?, ?);";
	private static final String SELECT_LINE_BY_KEY = "SELECT * FROM invoice_has_product WHERE invoice_id = ? AND product_id = ?;";
	private static final String SELECT_ALL_LINES_BY_INV = "SELECT  p.*, l.* FROM invoice_has_product l JOIN product p ON l.product_id = p.id WHERE l.invoice_id = ?;";
	private static final String UPDATE_INVOICE_LINE_BY_KEY = "UPDATE invoice_has_product SET quantity = ? WHERE invoice_id = ? AND product_id = ?;";
	private static final String DELETE_LINE_FROM_INVOICE = "DELETE FROM invoice_has_product WHERE invoice_id = ? AND product_id = ?;";


	@Override
	public List<InvoiceLine> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long add(InvoiceLine model) {
		
		InvoiceLineKey invoiceLineKey = model.getId();
		Product product = model.getProduct();
		Invoice invoice = model.getInvoice();
		float price = model.getPrice();
		Long quantity = model.getQuantity();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JDBCUtils.getConnection(); 
			preparedStatement = connection.prepareStatement(INSERT_INVOICE_LINE);
					
			preparedStatement.setLong(2, invoiceLineKey.getInvoiceId());
			preparedStatement.setLong(1, invoiceLineKey.getProductId());
			preparedStatement.setLong(3, quantity);
			preparedStatement.setFloat(4, price);
			if (logger.isDebugEnabled()) {
				logger.debug("ILDDAO request to add line" + preparedStatement.toString());
			}			
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
	public void update(InvoiceLine model) {

		InvoiceLineKey invoiceLineKey = model.getId();
		Product product = model.getProduct();
		Invoice invoice = model.getInvoice();
		float price = model.getPrice();
		Long quantity = model.getQuantity();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JDBCUtils.getConnection(); 
			preparedStatement = connection.prepareStatement(UPDATE_INVOICE_LINE_BY_KEY);
					
			preparedStatement.setLong(3, invoiceLineKey.getInvoiceId());
			preparedStatement.setLong(2, invoiceLineKey.getProductId());
			preparedStatement.setLong(1, quantity);
			if (logger.isDebugEnabled()) {
				logger.debug("ILDDAO request to update line" + preparedStatement.toString());
			}			
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
	}

	@Override
	public void delete(InvoiceLineKey model) {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_LINE_FROM_INVOICE);
			preparedStatement.setLong(1, model.getProductId());
			preparedStatement.setLong(2, model.getInvoiceId());
			if (logger.isDebugEnabled()) {
				logger.debug("ILDDAO request to delete line" + preparedStatement.toString());
			}			
			preparedStatement.execute();
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

	@Override
	public InvoiceLine getInvoiceLineByKey(InvoiceLineKey model) {
		ProductDao productDAO = new ProductDatabaseDaoImpl();
		Product product = productDAO.getById(model.getProductId());
		InvoiceDao invoiceDAO = new InvoiceDatabaseDaoImpl();
		Invoice invoice = invoiceDAO.getById(model.getInvoiceId());
		InvoiceLine invoiceLine = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_LINE_BY_KEY);
			preparedStatement.setLong(2, model.getInvoiceId());
			preparedStatement.setLong(1, model.getProductId());
			if (logger.isDebugEnabled()) {
				logger.debug("ILDDAO request to select invoice lines by KEY" + preparedStatement.toString());
			}
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				invoiceLine = new InvoiceLine(model, invoice, product, rs.getFloat(4), rs.getLong(3));
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
		
		return invoiceLine;
	}

}
