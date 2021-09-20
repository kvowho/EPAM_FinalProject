package net.voznjuk.ui;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9194754195440688180L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET processing started");
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST processing started");
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		System.out.println("Action defined to " + command.toString());
				
		/*
		 *
		 * i18n
		 * 
		 */
		HttpSession session = request.getSession();
		Locale locale = Locale.getDefault();
		String lng = locale.getCountry();
		String new_lng = request.getParameter("new_lang_loc");
		//System.out.println("Localization: session.par=" + session.getAttribute("lang_loc").toString() + "form selected par=" + request.getParameter("new_lang_loc"));
		
		if (request.getParameter("new_lang_loc") != null) {
			session.setAttribute("lang_loc", request.getParameter("new_lang_loc"));
			
			//System.out.println(" new_lang_loc is Null ");
			
		} else {
			if (session.getAttribute("lang_loc") == null) {
				session.setAttribute("lang_loc", "US");
			}
			//System.out.println(" new_lang_loc is Not Null ");			
		}
			

//		if (new_lng != null || !new_lng.equals(session.getAttribute("lang_loc"))) {
//			System.out.println("Lan Not Match. New is " + new_lng + " old one is " + session.getAttribute("lang_loc").toString());			
//		}

//		if (session.getAttribute("lang_loc") == null) {
//			lng = "US";
//			session.setAttribute("lang_loc", lng);
//			//System.out.println("Attr lang_loc = NULL");
//		} else {
//			//System.out.println("Attr lang_loc = NOT NULL" + session.getAttribute("lang_loc").toString());
//			System.out.println("Selected lang = " + new_lng);
//			// lng = (String) session.getAttribute("language");
//		}

		if (session.getAttribute("lang_loc").equals("UA"))
			locale = new Locale("uk", "UA");
		else if (session.getAttribute("lang_loc").equals("RU"))
			locale = new Locale("ru", "RU");
		else
			locale = Locale.US;

		ResourceBundle boundle = ResourceBundle.getBundle("Prop", locale);
		//System.out.println("BUNDLE: " + locale + " " + boundle.getString("HelloMessage"));

		for (Enumeration e = boundle.getKeys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			String s = boundle.getString(key);
			session.setAttribute(key, s);
		}
		/*
		 * 
		 */
		   
		
		
		
		page = command.execute(request);

		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else {
			//page = ConfigurationManager.getProperty("path.page.index");
			page = "index.jsp";
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}

