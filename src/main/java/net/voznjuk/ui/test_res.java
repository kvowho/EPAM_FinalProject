package net.voznjuk.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import net.voznjuk.dao.JDBCUtils;
import net.voznjuk.models.User;

public class test_res {

	public static void main(String[] args) {
		
		/*
		 *
		 * i18n
		 * 
		 */
		//HttpSession session = request.getSession();
		Locale locale = Locale.getDefault();
		String lng = locale.getCountry();

//		session.setAttribute("language", lng);
		lng = "RU";

		if (lng.equals("UA"))
			locale = new Locale("uk", "UA");
		else if (lng.equals("RU"))
			locale = new Locale("ru", "RU");
		else
			locale = Locale.US;

		ResourceBundle boundle = ResourceBundle.getBundle("resources", locale);
		System.out.println("BUNDLE: " + locale + " " + boundle.getString("interface.invoice"));

		for (Enumeration e = boundle.getKeys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			String s = boundle.getString(key);
//			session.setAttribute(key, s);
		}
		/*
		 * 
		 */
		

	}

}
