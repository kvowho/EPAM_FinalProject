package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import net.voznjuk.dao.InvoiceDao;
import net.voznjuk.dao.InvoiceLineDao;
import net.voznjuk.dao.ProductDao;
import net.voznjuk.dao.impl.InvoiceDatabaseDaoImpl;
import net.voznjuk.dao.impl.InvoiceLineDatabaseDaoImpl;
import net.voznjuk.dao.impl.ProductDatabaseDaoImpl;
import net.voznjuk.models.Invoice;
import net.voznjuk.models.InvoiceLine;
import net.voznjuk.models.InvoiceLineKey;
import net.voznjuk.models.Product;

import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class InvoiceCommand implements ActionCommand {
	
	final static Logger logger = Logger.getLogger(InvoiceCommand.class);

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		InvoiceDao invoiceDAO = new InvoiceDatabaseDaoImpl();
		String id = request.getParameter("id");

		if (request.getParameter("ex").equals("addl")) {
			// Request to add new line to the invoice
			
			String prod_id = request.getParameter("prod_id");
			String inv_id = request.getParameter("inv_id");
			String quantity = "0";
			
			if (logger.isDebugEnabled()) {
				logger.debug("LINES request to add lines to " + inv_id);
			}
			
			if ( prod_id != null && !prod_id.equals("") && inv_id != null && !inv_id.equals("")) {
				if (logger.isDebugEnabled()) {
					logger.debug("LINES request to add product " + prod_id + " to invoice " + inv_id );
				}
				//Procedure to add new line to invoice
				InvoiceLineDao invoiceLaineDAO = new InvoiceLineDatabaseDaoImpl();
				Invoice invoice = invoiceDAO.getById(Long.parseLong(inv_id));
				ProductDao productDAO = new ProductDatabaseDaoImpl();
				Product product = productDAO.getById(Long.parseLong(prod_id));
				InvoiceLineKey invoiceLineKey = new InvoiceLineKey(invoice.getId(), product.getId());
				InvoiceLine invoiceLine = new InvoiceLine(invoiceLineKey, invoice, product, product.getPrice(), Long.parseLong(quantity));
				invoiceLaineDAO.add(invoiceLine);
				request.setAttribute("id", inv_id);
				page = "/Controller?command=invoice&ex=disp&id="+inv_id;
				
			} else {
				ProductDao productDAO = new ProductDatabaseDaoImpl();
				List<Product> products = new ArrayList<>();
				products = productDAO.getAll();
				request.setAttribute("productList", products);
				request.setAttribute("inv_id", inv_id);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
				//dispatcher.forward(request, response);
				page = "/invaddline-form.jsp";			
			}		
			return page;

		}

		if (request.getParameter("ex").equals("upd")) {
			// Request to change user has been received
//				Product product = new Product();
//				product.setId(Long.parseLong(request.getParameter("id")));
//				product.setName(request.getParameter("name"));
//				product.setDescription(request.getParameter("description"));
//				product.setStockQuantity(Long.parseLong(request.getParameter("quantity")));
//				product.setPrice(Float.parseFloat(request.getParameter("price")));
//				product.setAvailabilityStatus(Integer.parseInt(request.getParameter("status")));
//				productDAO.update(product);
//				page = "/Controller?command=invoices";
		}
		
		if (request.getParameter("ex").equals("new")) {
			// Request for new invoice has been received
			if (logger.isDebugEnabled()) {
				logger.debug("INVOICES request to create new invoice");
			}
			String status = "Default status";
			String comment = "Default comment";
			Invoice invoice = new Invoice();
			invoice.setStatus(status);
			invoice.setComments(comment);
			invoice.setDate(Instant.now());
			long inv_id = invoiceDAO.add(invoice);
//			request.setAttribute("ex", "disp");
//			request.setAttribute("id", inv_id);
//			page = "/Controller?command=invoice";
			page = "/Controller?command=invoice&ex=disp&id=" + inv_id;
			
			
//				Product product = new Product();
//				product.setId(Long.parseLong(request.getParameter("id")));
//				product.setName(request.getParameter("name"));
//				product.setDescription(request.getParameter("description"));
//				product.setStockQuantity(Long.parseLong(request.getParameter("quantity")));
//				product.setPrice(Float.parseFloat(request.getParameter("price")));
//				product.setAvailabilityStatus(Integer.parseInt(request.getParameter("status")));
//				productDAO.update(product);
//				page = "/Controller?command=invoices";
		}
		
		if (request.getParameter("ex").equals("deli")) {
			// Request to delete invoice has been received
			if (logger.isDebugEnabled()) {
				logger.debug("INVOICES request to delete invoice");
			}

			long inv_id = invoiceDAO.delById(Long.parseLong(id));
//			request.setAttribute("ex", "disp");
//			request.setAttribute("id", inv_id);
//			page = "/Controller?command=invoice";
			page = "/Controller?command=invoices";
		}

		if (request.getParameter("ex").equals("disp")) {
			// Request to show invoice information
			if (logger.isDebugEnabled()) {
				logger.debug("INVOICE request to show lines for invoice " + id);
			}
			
			Invoice invoice = invoiceDAO.getById(Long.parseLong(id));
			InvoiceLineDao invoiceListDAO = new InvoiceLineDatabaseDaoImpl();
			List<InvoiceLine> lines = new ArrayList<>();
			lines = invoiceListDAO.getLinesByInvoice(invoice);
			request.setAttribute("invoiceLines", lines);
			request.setAttribute("invoice", invoice);
//			request.setAttribute("user", request.getAttribute("login"));
//			request.setAttribute("u_name", request.getAttribute("u_name"));
//			request.setAttribute("role", request.getAttribute("role"));
			page = "/invoice-form.jsp";
		}
		
		if (request.getParameter("ex").equals("del")) {
			// Request to delete line from invoice
			String prod_id = request.getParameter("prod_id");
			String inv_id = request.getParameter("inv_id");
			
			if (logger.isDebugEnabled()) {
				logger.debug("LINES request to delete line from " + inv_id);
			}
			
			if ( prod_id != null && !prod_id.equals("") && inv_id != null && !inv_id.equals("")) {
				if (logger.isDebugEnabled()) {
					logger.debug("LINES request to add product " + prod_id + " to invoice " + inv_id );
				}
				//Procedure to add new line to invoice
				InvoiceLineDao invoiceLaineDAO = new InvoiceLineDatabaseDaoImpl();
				InvoiceLineKey invoiceLineKey = new InvoiceLineKey(Long.parseLong(inv_id), Long.parseLong(prod_id));
				invoiceLaineDAO.delete(invoiceLineKey);				
			}
			request.setAttribute("id", inv_id);
			System.out.println("Invoice ID after deletion " + inv_id);
			page = "/Controller?command=invoice&ex=disp&id=" + inv_id;		
		}
		return page;
	}

}
