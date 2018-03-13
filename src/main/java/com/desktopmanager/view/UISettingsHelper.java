package com.desktopmanager.view;

import java.awt.Dimension;

import javax.swing.JComponent;

public final class UISettingsHelper {
	private final Dimension dimension;
	
	private UISettingsHelper(int width, int height) {
		dimension = new Dimension(width, height);
	}
	
	public static UISettingsHelper setDimension(int width, int height) {
		return new UISettingsHelper(width, height);
	}
	
	public void setComponentSize(JComponent component) {
		component.setPreferredSize(dimension);
	}
	
}
