package net.voznjuk.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.voznjuk.dao.InvoiceDao;
import net.voznjuk.dao.impl.InvoiceDatabaseDaoImpl;
import net.voznjuk.models.Invoice;

public class InvoicesCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		InvoiceDao invoiceDAO = new InvoiceDatabaseDaoImpl();
		List<Invoice> invoices = new ArrayList<>();
		invoices = invoiceDAO.getAll();
		request.setAttribute("invoiceList", invoices);
		//System.out.println(products.size());
		//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
		//dispatcher.forward(request, response);
		page = "/invoices-list.jsp";
		
		return page;
	}

}
