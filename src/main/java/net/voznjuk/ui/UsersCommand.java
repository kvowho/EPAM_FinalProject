package net.voznjuk.ui;

import java.util.ArrayList;
import java.util.List;
import net.voznjuk.dao.UserDao;
import net.voznjuk.dao.impl.UserDatabaseDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import net.voznjuk.models.User;

public class UsersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		UserDao userDAO = new UserDatabaseDaoImpl();
		List<User> users = new ArrayList<>();
		users = userDAO.getAll( 0, 1000, "");
		User user = userDAO.getByLogin("ivan");
		System.out.println(user.getPassword() );				
		request.setAttribute("usersList", users);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
		//dispatcher.forward(request, response);
		page = "/users-list.jsp";
		
		return page;
	}

}
