package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import net.voznjuk.dao.UserDao;
import net.voznjuk.dao.impl.UserDatabaseDaoImpl;
import net.voznjuk.models.User;

public class LoginCommand implements ActionCommand {
	
	final static Logger logger = Logger.getLogger(LoginCommand.class);
	
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		System.out.println("***** LoginCommand started ********" + login);
// проверка логина и пароля
//		if (LoginLogic.checkLogin(login, pass)) {
//			request.setAttribute("user", login);
//// определение пути к main.jsp
//			page = ConfigurationManager.getProperty("path.page.main");
//		} else {
//			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
//			page = ConfigurationManager.getProperty("path.page.login");
//		}
		UserDao userDAO = new UserDatabaseDaoImpl();
		User user = userDAO.getByLogin(login);
		boolean pass_check = userDAO.checkLoginPassword(login, pass);
		HttpSession session = request.getSession();
		session.setAttribute("role", user.getRole());
		session.setAttribute("user", login);
		session.setAttribute("role_name", userDAO.getAuthByRole(Long.parseLong(user.getRole())));
		
		if (logger.isDebugEnabled()) {
			logger.debug("LoginStage user " + login + " successfully get in with " + userDAO.getAuthByRole(Long.parseLong(user.getRole())) + " privileges");
			logger.debug("LoginStage USER password check " + pass_check);
		}
		
		
		
		if (user.getRole().equals("1") && pass_check) {
			//System.out.println("***** User name is Ivan ********");
			request.setAttribute("user", login);
			request.setAttribute("u_name", user.getLastname());
			request.setAttribute("role", user.getRole());
			page = "/Controller?command=users";
		} 
		if (user.getRole().equals("2") && pass_check ) {
			//System.out.println("***** Storekeeper ********");
			request.setAttribute("user", login);
			request.setAttribute("u_name", user.getLastname());
			request.setAttribute("role", user.getRole());
			page = "/Controller?command=products";
		} 
		if (user.getRole().equals("3") || user.getRole().equals("4") && pass_check) {
			//System.out.println("***** Cashier or Senior cashier ********");
			request.setAttribute("user", login);
			request.setAttribute("u_name", user.getLastname());
			request.setAttribute("role", user.getRole());
			page = "/Controller?command=invoices";
		} 
		
		if (logger.isDebugEnabled()) {
			logger.debug("LoginStage PAGE after selection " + page);
		}
		
		return page;
	}
}
