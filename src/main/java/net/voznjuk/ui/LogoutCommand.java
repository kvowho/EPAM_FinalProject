package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		//String page = ConfigurationManager.getProperty("path.page.index");
		System.out.println("**** Log out *****");
		String page = "/index.jsp";

		request.getSession().invalidate();
		return page;
	}
}
