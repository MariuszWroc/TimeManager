package com.desktopmanager.controller;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.model.Report;
import com.desktopmanager.view.ApplicationFrame;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings("serial")
public class ViewMapper extends ApplicationFrame implements Observer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationFrame.class.getName());
	private static final String REMOVE = "Remove";
	private static final String UPDATE = "Update";
	private static final String ADD = "Add";
	private static final String EMPTY_STRING = "";
	private static final String START = "Start";
	private static final String LOAD = "Load file";
	private static final String STOP = "Stop";
	private final Report model;

	public ViewMapper(Report model) {
		this.model = model;
		this.model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		copyModelToView();
	}

	public void copyModelToView() {
		LOGGER.info("pressed");
		if (EMPTY_STRING.equals(model.getName()) || EMPTY_STRING.equals(model.getStartDate())) {
			validation();
		} else {
			updateModelByCommand();
		}
		
		refreshNameAndDate();
	}

	private void validation() {
	}

	private void updateModelByCommand() {
		switch (model.getActionName()) {
		case ADD:
			LOGGER.info("Added");
			String[] row = { model.getName(), model.getStartDate() };
			getMainPanel().getReportPanel().getTableModel().addRow(row);
			break;
		case UPDATE:
			LOGGER.info("Updated");
			updateRow(model.getRowId());
			break;
		case REMOVE:
			LOGGER.info("Removed");
			removeRow(model.getRowId());
			break;
		case START:
			LOGGER.info("Start");
			getMainPanel().getButtonPanel().getDateField().setText(model.getName());
			break;
		case LOAD:
			LOGGER.info("Load file");
			getMainPanel().getButtonPanel().getDateField().setText(model.getName());
			break;
		case STOP:
			LOGGER.info("Stop");
			updateRow(model.getRowId());
			break;
		}
	}

	private void refreshNameAndDate() {
		getMainPanel().getButtonPanel().getNameField().setText(model.getName());
		getMainPanel().getButtonPanel().getDateField().setText(model.getStartDate());
	}

	private void removeRow(int rowId) {
		if (rowId >= 0) {
			getMainPanel().getReportPanel().getTableModel().removeRow(rowId);
		}
	}

	private void updateRow(int rowId) {
		if (rowId >= 0) {
			if (model.getName() != null) {
				getMainPanel().getReportPanel().getTableModel().setValueAt(model.getName(), rowId, 0);
			}
			if (model.getStartDate() != null) {
				getMainPanel().getReportPanel().getTableModel().setValueAt(model.getStartDate(), rowId, 1);
			}
			if (model.getEndDate() != null && !"".equals(model.getEndDate())) {
				getMainPanel().getReportPanel().getTableModel().setValueAt(model.getStartDate(), rowId, 2);
			}
		}
	}

}
