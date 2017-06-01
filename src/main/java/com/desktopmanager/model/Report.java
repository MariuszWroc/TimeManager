package com.desktopmanager.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * @author Mariusz Czarny
 *
 */

public class Report extends Observable {
	private String id;
	private Map<String, String> timeByDays;
	private String name;
	private String startDate;
	private String endDate;
	private Integer rowId;
	private String actionName;

	public Report() {
		this.timeByDays = new HashMap<>();
	}

//	public Report(String id, Map<String, String> timeByDays, String name, String date, Integer rowId,
//			String actionName) {
//		this.id = id;
//		this.timeByDays = timeByDays;
//		this.name = name;
//		this.startDate = date;
//		this.rowId = rowId;
//		this.actionName = actionName;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getTimeByDays() {
		return timeByDays;
	}

	public void setTimeByDays(Map<String, String> timeByDays) {
		this.timeByDays = timeByDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", timeByDays=" + timeByDays + ", name=" + name + ", date=" + startDate + ", rowId="
				+ rowId + ", actionName=" + actionName + "]";
	}

	public void setChangedAndNotifyObservers() {
		setChanged();
		notifyObservers();
	}

}
