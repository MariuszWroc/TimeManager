package com.desktopmanager.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.model.ViewModel;
import com.desktopmanager.view.ButtonPanel;
import com.desktopmanager.view.ReportPanel;

/**
 * @author Mariusz Czarny
 *
 */
public class MainPanelController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainPanelController.class.getName());
	private static final int DATE_COULMN_POSITION = 1;
	private static final int NAME_COLUMN_POSITION = 0;
	private static final String NO_BUTTON_ACTION = "NONE";
	private static final int NO_ROW_TO_SELECT = -1;
	
	public MainPanelController(ViewModel model, ViewMapper view) {
		addButtonsListeners(model, view);
	}
	
	private void addButtonsListeners(ViewModel model, ViewMapper view) {
		ButtonPanel buttonPanel = view.getMainPanel().getButtonPanel();
		ReportPanel reportPanel = view.getMainPanel().getReportPanel();
		
		buttonPanel.getAddButton().addActionListener(event -> {
			String name = buttonPanel.getNameField().getText();
			String date = buttonPanel.getDateField().getText();
			String actionName = event.getActionCommand();
			int rowId = reportPanel.getReportTable().getSelectedRow();
			model.setName(name);
			model.setStartDate(date);
			model.setRowId(rowId);
			model.setActionName(actionName);

			model.setChangedAndNotifyObservers();
			LOGGER.info("add button pushed");
		});

		buttonPanel.getRemoveButton().addActionListener(event -> {
			int rowId = reportPanel.getReportTable().getSelectedRow();
			String actionName = event.getActionCommand();
			model.setRowId(rowId);
			model.setActionName(actionName);
			
			model.setChangedAndNotifyObservers();
			LOGGER.info("remove button pushed");
		});

		buttonPanel.getUpdateButton().addActionListener(event -> {
			int rowId = reportPanel.getReportTable().getSelectedRow();
			String actionName = event.getActionCommand();
			String name = buttonPanel.getNameField().getText();
			String date = buttonPanel.getDateField().getText();
			model.setRowId(rowId);
			model.setActionName(actionName);
			model.setName(name);
			model.setStartDate(date);

			model.setChangedAndNotifyObservers();
			LOGGER.info("update button pushed");
		});
		
		reportPanel.getReportTable().getSelectionModel().addListSelectionListener(event -> {
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
}
