package net.voznjuk.ui;

import java.util.ArrayList;
import java.util.List;

import net.voznjuk.dao.ProductDao;
import net.voznjuk.dao.UserDao;
import net.voznjuk.dao.impl.ProductDatabaseDaoImpl;
import net.voznjuk.dao.impl.UserDatabaseDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import net.voznjuk.models.Product;
import net.voznjuk.models.User;

public class ProductsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		ProductDao productDAO = new ProductDatabaseDaoImpl();
		List<Product> products = new ArrayList<>();
		products = productDAO.getAll( 0, 1000, "");
		request.setAttribute("productList", products);
		System.out.println(products.size());
		//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
		//dispatcher.forward(request, response);
		page = "/products-list.jsp";
		
		return page;
	}

}
