package com.desktopmanager.persistence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.desktopmanager.util.MapAdapter;

@XmlRootElement
public class ReportEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private Map<String, String> timeByDays;
	
	public ReportEntity() {
	}
	
	public ReportEntity(String id, Map<String, String> timeByDays) {
		this.id = id;
		this.timeByDays = timeByDays;
	}
	
	public String getId() {
		return id == null ? "0" : id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, String> getTimeByDays() {
		return timeByDays == null ? new HashMap<>() : timeByDays;
	}
	public void setTimeByDays(Map<String, String> timeByDays) {
		this.timeByDays = timeByDays;
	}
	
	@Override
	public String toString() {
		return "ReportEntity [id=" + id + ", timeByDays=" + timeByDays + "]";
	}
	
}
