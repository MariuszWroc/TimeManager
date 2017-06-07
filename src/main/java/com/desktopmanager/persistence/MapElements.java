package com.desktopmanager.persistence;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mariusz Czarny
 *
 */
@XmlRootElement
public class MapElements {
	@XmlElement(name = "id")
	public String key;
	@XmlElement(name = "details")
	public EventEntity value;

	@SuppressWarnings("unused")
	private MapElements() {
	} // Required by JAXB

	public MapElements(String key, EventEntity value) {
		this.key = key;
		this.value = value;
	}
}
