package com.desktopmanager.controller;

import static com.desktopmanager.constant.DefaultValues.PATH_TO_FILE;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Map;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.logic.TimeCounter;
import com.desktopmanager.model.ViewModel;
import com.desktopmanager.persistence.EventEntity;
import com.desktopmanager.persistence.ReportDao;
import com.desktopmanager.persistence.ReportEntity;

/**
 * @author Mariusz Czarny
 *
 */
public class MenuController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class.getName());
	private static final String DEFAULT_CATALOG = "user.home";
	
	public MenuController(ViewModel model, ReportEntity entity, ViewMapper view) {
		addMenuItemsListeners(model, entity, view);
	}
	
	private void addMenuItemsListeners(ViewModel model, ReportEntity entity, ViewMapper view) {
		ReportDao dao = new ReportDao();
		
		view.getSaveItem().addActionListener(event -> {
			model.setActionName("Save file");
			model.setChangedAndNotifyObservers();
			String fileName = model.getUser().getFirstName() + model.getUser().getLastName();
			dao.convertObjectToXML(entity, getPathWithUserFileName(fileName));
			
			LOGGER.info("save button pushed");
		});

		view.getLoadItem().addActionListener(event -> {
			model.setActionName(event.getActionCommand());
			String fileName = model.getUser().getFirstName() + model.getUser().getLastName();
			ReportEntity loadEntity = dao.convertXMLToObject(getPathWithUserFileName(fileName));
			Map<String, EventEntity> events = loadEntity.getEvents();
			LOGGER.info("events model " + events.toString());
			events.forEach((k,v) -> {
				model.setRowId(new Integer(k));
				model.setName(v.getName());
				model.setStartDate(v.getStartDate());
				model.setEndDate(v.getEndDate());
				model.setChangedAndNotifyObservers();
			});
			
			LOGGER.info("load button pushed ");
		});

		view.getSettingsItem().addActionListener(event -> {
			JFileChooser fileChooser = new JFileChooser();
			File defaultPath = new File(System.getProperty(DEFAULT_CATALOG));
			fileChooser.setCurrentDirectory(defaultPath);
			int result = fileChooser.showOpenDialog(view);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				LOGGER.info("Selected file: " + selectedFile.getAbsolutePath());
			}
		});
		
		view.getUserItem().addActionListener(event -> {
			model.setActionName(event.getActionCommand());
			LOGGER.info("model: " + model.getActionName());
			model.setChangedAndNotifyObservers();
			//TODO: to improve
			view.getMainPanel().setVisible(false);
//			view.getContentPane().removeAll();
			view.getContentPane().add(view.getUserPanel());
			view.getContentPane().invalidate();
			view.getContentPane().validate();
		});
		
		view.getActualDayItem().addActionListener(event -> {
			model.setActionName(event.getActionCommand());
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("actual day pushed");
		});
		
		view.getActualMonthItem().addActionListener(event -> {
			model.setActionName(event.getActionCommand());
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("actual month pushed");
		});
		
		view.getStartItem().addActionListener(event -> {
			String date = TimeCounter.getActualTime();
			String actionName = event.getActionCommand();
			
			model.setStartDate(date);
			model.setActionName(actionName);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("start button pushed");
		});
		
		view.getStopItem().addActionListener(event -> {
			int rowId = view.getMainPanel().getReportPanel().getReportTable().getSelectedRow();
			String date = TimeCounter.getActualTime();
			String actionName = event.getActionCommand();
			
			model.setRowId(rowId);
			model.setEndDate(date);
			model.setActionName(actionName);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("stop button pushed");
		});
	}

	private String getPathWithUserFileName(String fileName) {
		return PATH_TO_FILE.getValue() + fileName;
	}
}
