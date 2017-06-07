package com.desktopmanager.persistence;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportDaoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportDaoTest.class.getName());
	private static ReportDao dao;
	private static final String path = "/Users/czarnym/test.txt";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ReportDao();
	}

	@Test
	public void testConvertObjectToXML() {
		Map<String, EventEntity> timeByDays = new HashMap<>();
		timeByDays.put("1", new EventEntity("name", "startDate", "endDate"));
		String id = "1";
		ReportEntity entity = new ReportEntity(id, timeByDays);
		dao.convertObjectToXML(entity, path);
	}

	@Test
	public void testConvertXMLToObject() {
	}

}
