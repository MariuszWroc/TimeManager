package com.desktopmanager.persistence;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"name", "startDate", "endDate"})
public class EventEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String startDate;
	private String endDate;
	
	/**
	 * Required by JAXB
	 */
	@SuppressWarnings("unused")
	private EventEntity() {
	}
	
	public EventEntity(String name, String startDate, String endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	@Override
	public String toString() {
		return "EventEntity [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
