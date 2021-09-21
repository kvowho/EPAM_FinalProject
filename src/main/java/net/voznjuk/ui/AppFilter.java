package net.voznjuk.ui;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.voznjuk.dao.UserDao;
import net.voznjuk.dao.impl.UserDatabaseDaoImpl;
import net.voznjuk.models.User;
import static java.util.Objects.nonNull;

public class AppFilter implements Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		final HttpServletRequest req = (HttpServletRequest) arg0;
        final HttpServletResponse res = (HttpServletResponse) arg1;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        
        final HttpSession session = req.getSession();
        
        UserDao userDAO = new UserDatabaseDaoImpl();
		
		
        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            String role = (String) session.getAttribute("role");

            moveToMenu(req, res, role);


        } else if (userDAO.checkLoginPassword(login, password)) {

        	User user = userDAO.getByLogin(login);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", user.getRole());

            moveToMenu(req, res, user.getRole());

        } else {

            moveToMenu(req, res, "");
        }
		
		
	}
	
    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {


        if (role.equals("1")) {

            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);

        } else if (role.equals("2")) {

            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

        } else if (role.equals("3") || role.equals("4")) {

            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

        } else {

            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }

}
