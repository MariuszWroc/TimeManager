package com.desktopmanager.constant;

/**
 * @author Mariusz Czarny
 *
 */
public enum DefaultValues {
	TITLE("Aplikacja"),
	PATH_TO_FILE("/Users/czarnym/test.txt"),
	CONFIG_FILE("/Users/czarnym/config.properties"),
	TIME_FORMAT("HH:mm:ss"),
	DATE_FORMAT("yyyy-MM-dd");
	
	private final String value;
	
	private DefaultValues(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
