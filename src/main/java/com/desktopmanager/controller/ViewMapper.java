package com.desktopmanager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.model.ViewModel;
import com.desktopmanager.persistence.EventEntity;
import com.desktopmanager.persistence.ReportEntity;
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
	private static final String SAVE = "Save file";
	private static final String STOP = "Stop";
	private static final String PROFILE = "Change user";
	private static final String CHANGE = "Change day";
	private final ViewModel model;
	private final ReportEntity entity;

	public ViewMapper(ViewModel model, ReportEntity entity) {
		this.model = model;
		this.entity = entity;
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
		LOGGER.info(model.getActionName());
		switch (model.getActionName()) {
		case ADD:
			LOGGER.info("Added");
			String[] addedRow = { model.getName(), model.getStartDate() };
			getMainPanel().getReportPanel().getTableModel().addRow(addedRow);
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
		case STOP:
			LOGGER.info("Stop");
			updateRow(model.getRowId());
			break;
		case LOAD:
			LOGGER.info("Load");
			String[] loadedRow = { model.getName(), model.getStartDate(), model.getEndDate() };
			getMainPanel().getReportPanel().getTableModel().addRow(loadedRow);
			break;
		case SAVE:
			LOGGER.info("Save");
			Map<String, EventEntity> eventsToSave = new HashMap<>();
			int rowCount = getMainPanel().getReportPanel().getTableModel().getRowCount();
			for (int i = 0; i < rowCount; i++) {
				String endDate = "";
				String name = getMainPanel().getReportPanel().getTableModel().getValueAt(i, 0).toString();
				String startDate = getMainPanel().getReportPanel().getTableModel().getValueAt(i, 1).toString();
				if (getMainPanel().getReportPanel().getTableModel().getValueAt(i, 2) != null) {
					endDate = getMainPanel().getReportPanel().getTableModel().getValueAt(i, 2).toString();
				}
				EventEntity oneEvent = new EventEntity(name, startDate, endDate);
				eventsToSave.put(new Integer(i).toString(), oneEvent);
			}

			entity.setEvents(eventsToSave);
			break;
		case PROFILE:
			LOGGER.info("User profile accepted");
			getUserPanel().setVisible(false);
			getMainPanel().setVisible(true);
			getContentPane().invalidate();
			getContentPane().validate();
			break;
		case CHANGE:
			LOGGER.info("Day changed");
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
			if (model.getEndDate() != null && !EMPTY_STRING.equals(model.getEndDate())) {
				getMainPanel().getReportPanel().getTableModel().setValueAt(model.getStartDate(), rowId, 2);
			}
		}
	}

}
