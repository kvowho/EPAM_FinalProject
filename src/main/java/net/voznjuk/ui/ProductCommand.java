package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;

import net.voznjuk.dao.ProductDao;
import net.voznjuk.dao.impl.ProductDatabaseDaoImpl;
import net.voznjuk.models.Product;

public class ProductCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		ProductDao productDAO = new ProductDatabaseDaoImpl();
		String id = request.getParameter("id");
		
		if ( id != null && !id.equals("") && !id.equals("0")) {
			
			if (request.getParameter("ex").equals("del")) {
				// Request to delete user has been received
				productDAO.delById(Long.parseLong(id));
				page = "/Controller?command=products";
			}
			
			if (request.getParameter("ex").equals("upd")) {
				// Request to change user has been received 
				Product product = new Product();
				product.setId(Long.parseLong(request.getParameter("id")));
				product.setName(request.getParameter("name"));
				product.setDescription(request.getParameter("description"));
				product.setStockQuantity(Long.parseLong(request.getParameter("quantity")));
				product.setPrice(Float.parseFloat(request.getParameter("price")));
				product.setAvailabilityStatus(Integer.parseInt(request.getParameter("status")));
				productDAO.update(product);
				page = "/Controller?command=products";
			}

			if (request.getParameter("ex").equals("disp")) {
				//Request to show user information
				System.out.println("ID not empty" + Long.parseLong(id));
				Product product = productDAO.getById(Long.parseLong(id));
				request.setAttribute("product", product);
				page = "/product-form.jsp";
			}

		} else {
			System.out.println("New product form");
			page = "/product-form.jsp";
		}
		
		
		if (id != null && id.equals("0")) {
			//System.out.println("New user form has been received");
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setStockQuantity(Long.parseLong(request.getParameter("quantity")));
			product.setPrice(Float.parseFloat(request.getParameter("price")));
			product.setAvailabilityStatus(Integer.parseInt(request.getParameter("status")));
			productDAO.add(product);
			page = "/Controller?command=products";
			
			//System.out.println(user.toString());
		}
		
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
		//dispatcher.forward(request, response);
		//page = "/user-form.jsp";
		
		return page;
	}

}
