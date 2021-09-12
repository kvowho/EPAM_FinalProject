package net.voznjuk.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.voznjuk.dao.UserDao;
import net.voznjuk.dao.impl.UserDatabaseDaoImpl;
import net.voznjuk.models.User;

public class UserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		UserDao userDAO = new UserDatabaseDaoImpl();
		
		String id = request.getParameter("id");
		
		if ( !id.equals("")) {
			System.out.println("ID not empty" + Integer.parseInt(id) );
		} else {
			System.out.println("New user form");
		}
		
		
		
		//User user = userDAO.getById(valueOf(id));
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
		//dispatcher.forward(request, response);
		page = "/user-form.jsp";
		
		return page;
	}

}
