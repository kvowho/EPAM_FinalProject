package net.voznjuk.ui;

import java.util.ResourceBundle;

public class test_res {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle bundleDefault = ResourceBundle.getBundle("resources");
		System.out.println(bundleDefault.getString("somemess"));
		String page = ConfigurationManager.getProperty("path.page.main");
		System.out.println(page);

	}

}
