package com.desktopmanager.model;

import java.util.Observable;

/**
 * @author Mariusz Czarny
 *
 */
public class Event extends Observable{
	private String name;
	private String date;
	
	public Event(String name, String date) {
		this.name = name;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setChangedAndNotifyObservers(){
		setChanged();
		notifyObservers();
	}
}
