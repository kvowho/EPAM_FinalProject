package net.voznjuk.ui;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ActionFactory {
	
	final static Logger logger = Logger.getLogger(InvoiceCommand.class);
	
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		
		if (logger.isDebugEnabled()) {
			logger.debug("ActionFactory requested command is " + request.getParameter("command"));
		}

		String action = request.getParameter("command");

		if (action == null || action.isEmpty()) {
			
			if (logger.isDebugEnabled()) {
				logger.error("ActionFactory wrong or empty \"action\" " + current.toString()); 
			}
			request.setAttribute("wrongAction", MessageManager.getProperty("message.wrongaction"));

			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
