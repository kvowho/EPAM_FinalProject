package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;

import net.voznjuk.dao.InvoiceDao;
import net.voznjuk.dao.impl.InvoiceDatabaseDaoImpl;
import net.voznjuk.models.Invoice;
import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoField;

public class InvoiceCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		InvoiceDao invoiceDAO = new InvoiceDatabaseDaoImpl();
		String id = request.getParameter("id");
		System.out.println("InvoiceCommand started with " + request.getParameter("ex")+ request.getParameter("test"));

		if (request.getParameter("ex").equals("del")) {
			// Request to delete user has been received
			invoiceDAO.delById(Long.parseLong(id));
			page = "/Controller?command=products";
		}

		if (request.getParameter("ex").equals("new")) {
			// Request to create new invoice has been received
			// To create new blank invoice and get ID
			
			//Instant instant = Instant.now();
			Instant instant = Instant.now().with( ChronoField.NANO_OF_SECOND , 123_456_789L );
			Timestamp timestamp = Timestamp.from(instant);
			Invoice invoice = new Invoice();
			invoice.setStatus("Just created");
			invoice.setDate(instant);
			invoice.setComments("Comments if any");
			//System.out.println(instant.toString());
			//System.out.println(timestamp.toString());
			long createdID = invoiceDAO.add(invoice);

			// To send new created invoice to edit form by ID

			page = "/Controller?command=invoices";
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

		if (request.getParameter("ex").equals("disp")) {
			// Request to show user information
//				System.out.println("ID not empty" + Long.parseLong(id));
//				Product product = productDAO.getById(Long.parseLong(id));
//				request.setAttribute("product", product);
//				page = "/invoice-form.jsp";
		}

		return page;
	}

}