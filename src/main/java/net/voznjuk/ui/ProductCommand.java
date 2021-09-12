package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;
import net.voznjuk.dao.UserDao;
import net.voznjuk.dao.impl.UserDatabaseDaoImpl;
import net.voznjuk.models.User;

public class ProductCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		UserDao userDAO = new UserDatabaseDaoImpl();
		
		String id = request.getParameter("id");
		
		if ( id != null && !id.equals("") && !id.equals("0")) {
			
			if (request.getParameter("ex").equals("del")) {
				// Request to delete user has been received
				userDAO.delById(Long.parseLong(id));
				page = "/Controller?command=users";
			}
			
			if (request.getParameter("ex").equals("upd")) {
				// Request to change user has been received 
				User user = new User();
				user.setId(Long.parseLong(request.getParameter("id")));
				user.setFirstname(request.getParameter("firstname"));
				user.setLastname(request.getParameter("lastname"));
				user.setLogin(request.getParameter("login"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
				userDAO.update(user);
				page = "/Controller?command=users";
			}

			if (request.getParameter("ex").equals("disp")) {
				//Request to show user information
				System.out.println("ID not empty" + Long.parseLong(id));
				User user = userDAO.getById(Long.parseLong(id));
				request.setAttribute("user", user);
				page = "/user-form.jsp";
			}

		} else {
			System.out.println("New user form");
			page = "/user-form.jsp";
		}
		
		
		if (id != null && id.equals("0")) {
			//System.out.println("New user form has been received");
			User user = new User();
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			user.setRole(request.getParameter("role"));
			userDAO.add(user);
			page = "/Controller?command=users";
			//System.out.println(user.toString());
		}
		
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
		//dispatcher.forward(request, response);
		//page = "/user-form.jsp";
		
		return page;
	}

}
