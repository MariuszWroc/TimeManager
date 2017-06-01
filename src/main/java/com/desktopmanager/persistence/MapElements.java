package com.desktopmanager.persistence;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Mariusz Czarny
 *
 */
public class MapElements {
	@XmlElement
	public String key;
	@XmlElement
	public String value;

	@SuppressWarnings("unused")
	private MapElements() {
	} // Required by JAXB

	public MapElements(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
