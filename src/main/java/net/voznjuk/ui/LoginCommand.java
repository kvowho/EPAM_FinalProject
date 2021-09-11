package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
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
		if (login.equals("ivan")) {
			System.out.println("***** User name is Ivan ********");
			request.setAttribute("user", login);
			page = "/first.jsp";
		} else {
			page = "/second.jsp";
		}
		
		return page;
	}
}
