package com.desktopmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.model.UserViewModel;
import com.desktopmanager.model.ViewModel;
import com.desktopmanager.view.UserFormPanel;

/**
 * @author Mariusz Czarny
 *
 */
public class UserPanelController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserPanelController.class.getName());

	public UserPanelController(ViewModel model, ViewMapper view) {
		addButtonListener(model, view);
	}

	private void addButtonListener(ViewModel model, ViewMapper view) {
		view.getUserPanel().getAcceptButtonPanel().getAcceptButton().addActionListener(event -> {
			UserViewModel user = model.getUser();
			UserFormPanel userFormPanel = view.getUserPanel().getUserFormPanel();
			
			model.setName(event.getActionCommand());
			user.setFirstName(userFormPanel.getFirstNameTextField().getText());
			user.setLastName(userFormPanel.getLastNameTextField().getText());
			
			LOGGER.info("user view button pushed");
			model.setChangedAndNotifyObservers();
		});
	}
}
