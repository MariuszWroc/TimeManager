package com.desktopmanager.model;

import java.beans.Transient;
import java.util.Observable;

/**
 * @author Mariusz Czarny
 *
 */

public class Event extends Observable {
	private Integer rowId;
	private String name;
	private String startDate;
	private String endDate;
	private String actionName;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void rowId(String name) {
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

	@Transient
	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String toString() {
		return "Report [rowId=" + rowId + ", name=" + name + ", date=" + startDate + ", actionName=" + actionName + "]";
	}

	public void setChangedAndNotifyObservers() {
		setChanged();
		notifyObservers();
	}

}
