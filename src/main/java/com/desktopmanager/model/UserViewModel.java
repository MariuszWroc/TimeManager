package com.desktopmanager.model;

import java.util.Observable;

public class UserViewModel extends Observable{
	private String firstName;
	private String lastName;
	
	public UserViewModel(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "UserViewModel [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public void setChangedAndNotifyObservers() {
		setChanged();
		notifyObservers();
	}
}
