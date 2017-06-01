package com.desktopmanager.constant;

/**
 * @author Mariusz Czarny
 *
 */
public enum FrameSettings {
	WIDTH(600),
	HEIGHT(600);
	
	private final int dimention;
	
	private FrameSettings(int dimention) {
		this.dimention = dimention;
	}
	
	public int getDimention() {
		return dimention;
	}
}
