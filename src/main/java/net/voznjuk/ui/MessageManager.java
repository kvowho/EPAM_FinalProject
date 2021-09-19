package net.voznjuk.ui;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
	static Locale locale = new Locale("ru", "RU");
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);

	private MessageManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
