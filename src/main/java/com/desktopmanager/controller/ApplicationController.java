package com.desktopmanager.controller;

import static com.desktopmanager.constant.DefaultValues.PATH_TO_FILE;
import static com.desktopmanager.constant.FrameSettings.HEIGHT;
import static com.desktopmanager.constant.FrameSettings.WIDTH;

import java.awt.Dimension;
import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.model.Event;
import com.desktopmanager.persistence.ReportDao;
import com.desktopmanager.persistence.ReportEntity;
import com.desktopmanager.view.MainPanel;

/**
 * @author Mariusz Czarny
 *
 */
public class ApplicationController {
	private static final int DATE_COULMN_POSITION = 1;
	private static final int NAME_COLUMN_POSITION = 0;
	private static final String NO_BUTTON_ACTION = "NONE";
	private static final int NO_ROW_TO_SELECT = -1;
	private static final String DEFAULT_CATALOG = "user.home";
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class.getName());
	private Event model;
	private ViewMapper view;
	private ReportEntity entity;
	private AtomicInteger counter = new AtomicInteger(1);

	public ApplicationController() {
		model = new Event();
		entity = new ReportEntity(counter.incrementAndGet());
		view = new ViewMapper(model, entity);
		view.setMinimumSize(new Dimension(HEIGHT.getDimention(), WIDTH.getDimention()));
		init();
	}

	public void start() {
		view.setVisible(true);
	}

	private void init() {
		MainPanel mainPanel = view.getMainPanel();
		
		addButtonsListeners(mainPanel);
		addMenuItemsListeners();

		view.getMainPanel().getReportPanel().getReportTable().getSelectionModel().addListSelectionListener(event -> {
			if (view.getMainPanel().getReportPanel().getReportTable().getSelectedRow() > NO_ROW_TO_SELECT) {
				model.setActionName(NO_BUTTON_ACTION);
				String name = view.getMainPanel().getReportPanel().getReportTable().getValueAt(view.getMainPanel().getReportPanel().getReportTable().getSelectedRow(), NAME_COLUMN_POSITION).toString();
				model.setName(name);
				String date = view.getMainPanel().getReportPanel().getReportTable().getValueAt(view.getMainPanel().getReportPanel().getReportTable().getSelectedRow(), DATE_COULMN_POSITION).toString();
				model.setStartDate(date);
				
				model.setChangedAndNotifyObservers();
				LOGGER.info("Report panel name {}", name);
				LOGGER.info("Report panel date {}", date);
	        }
		});
		
	}

	private void addMenuItemsListeners() {
		view.getSaveItem().addActionListener(event -> {
			ReportDao dao = new ReportDao();
//			LOGGER.info("model contains " + reportModel.getRowId() + " " + reportModel.getTimeByDays());
			
			dao.convertObjectToXML(entity, PATH_TO_FILE.getValue());
			
			LOGGER.info("save button pushed");
		});

		view.getLoadItem().addActionListener(event -> {
			ReportDao dao = new ReportDao();
			ReportEntity fileReport = dao.convertXMLToObject(PATH_TO_FILE.getValue());
//			reportModel.setTimeByDays(fileReport.getTimeByDays());
			model.setActionName(event.getActionCommand());
			model.setName("");
			model.setStartDate("");
			model.setRowId(1);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("load button pushed");
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
		
		view.getStartItem().addActionListener(event -> {
			String date = LocalDateTime.now().toString();
			model.setStartDate(date);
			String actionName = event.getActionCommand();
			model.setActionName(actionName);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("start button pushed");
		});
		
		view.getStopItem().addActionListener(event -> {
			int rowId = view.getMainPanel().getReportPanel().getReportTable().getSelectedRow();
			model.setRowId(rowId);
			String date = LocalDateTime.now().toString();
			model.setEndDate(date);
			String actionName = event.getActionCommand();
			model.setActionName(actionName);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("stop button pushed");
		});
	}

	private void addButtonsListeners(MainPanel mainPanel) {
		mainPanel.getButtonPanel().getAddButton().addActionListener(event -> {
			String name = mainPanel.getButtonPanel().getNameField().getText();
			String date = LocalDateTime.now().toString();
			String actionName = event.getActionCommand();
			int rowId = mainPanel.getReportPanel().getReportTable().getSelectedRow();
			model.setName(name);
			model.setStartDate(date);
			model.setRowId(rowId);
			System.out.println(rowId);
			model.setActionName(actionName);

			model.setChangedAndNotifyObservers();
			
			LOGGER.info("add button pushed");
		});

		mainPanel.getButtonPanel().getRemoveButton().addActionListener(event -> {
			int rowId = mainPanel.getReportPanel().getReportTable().getSelectedRow();
			System.out.println(rowId);
			String actionName = event.getActionCommand();
			System.out.println(rowId);
			model.setRowId(rowId);
			model.setActionName(actionName);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("remove button pushed");
		});

		mainPanel.getButtonPanel().getUpdateButton().addActionListener(event -> {
			int rowId = mainPanel.getReportPanel().getReportTable().getSelectedRow();
			String actionName = event.getActionCommand();
			String name = mainPanel.getButtonPanel().getNameField().getText();
			String date = mainPanel.getButtonPanel().getDateField().getText();
			System.out.println(rowId);
			model.setRowId(rowId);
			model.setActionName(actionName);
			model.setName(name);
			model.setStartDate(date);

			model.setChangedAndNotifyObservers();
			LOGGER.info("update button pushed");
		});
	}
}
