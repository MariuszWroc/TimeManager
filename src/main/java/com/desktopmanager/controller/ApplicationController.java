package com.desktopmanager.controller;

import static com.desktopmanager.constant.FrameSettings.HEIGHT;
import static com.desktopmanager.constant.FrameSettings.WIDTH;

import java.awt.Dimension;

import com.desktopmanager.model.ViewModel;
import com.desktopmanager.persistence.ReportEntity;

/**
 * @author Mariusz Czarny
 *
 */
public class ApplicationController {
	private ViewModel model;
	private ViewMapper view;
	private ReportEntity entity;

	public ApplicationController() {
		model = new ViewModel();
		entity = new ReportEntity();
		view = new ViewMapper(model, entity);
		view.setMinimumSize(new Dimension(HEIGHT.getDimention(), WIDTH.getDimention()));
		init();
	}

	public void start() {
		view.setVisible(true);
	}

	private void init() {
		addMainButtonsListeners();
		addUserPanelListeners();
		addMenuItemsListeners();
	}
	
	private void addMenuItemsListeners() {
		new MenuController(model, entity, view);
	}

	private void addUserPanelListeners() {
		new UserPanelController(model, view);
	}

	private void addMainButtonsListeners() {
		new MainPanelController(model, view);
	}

}
