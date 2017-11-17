package com.desktopmanager.persistence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.desktopmanager.util.MapAdapter;

@XmlRootElement
@XmlType(propOrder={"id", "events"})
public class ReportEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Map<String, EventEntity> events;
	
	/**
	 *  Requeired by JAXB
	 */
	public ReportEntity() {
	}
	
	public ReportEntity(Integer id) {
		this.id = id;
		events = new HashMap<>();
	}
	
	public ReportEntity(Integer id, Map<String, EventEntity> events) {
		this.id = id;
		this.events = events;
	}

	public Integer getId() {
		return id == null ? 0 : id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, EventEntity> getEvents() {
		return events;
	}

	public void setEvents(Map<String, EventEntity> events) {
		this.events = events;
	}
	
	@Override
	public String toString() {
		return "ReportEntity [id=" + id + ", events=" + events + "]";
	}
	
}
