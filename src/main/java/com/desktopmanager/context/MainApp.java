package com.desktopmanager.context;

import com.desktopmanager.controller.ApplicationController;

/**
 * @author Mariusz Czarny
 *
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationController controller = new ApplicationController();
		controller.start();	
	}
}
