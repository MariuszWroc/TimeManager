package com.desktopmanager.logic;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeCounterTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeCounter.class.getName());
	private static TimeCounter counter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		counter = new TimeCounter();
	}

	@Test
	public void testGetStartTime() {
		LocalDateTime startTime = counter.getStartTime();
		LOGGER.info(startTime.toString());
	}

	@Test
	public void testGetActualTime() {
		LocalDateTime actualTime = counter.getActualTime();
		LOGGER.info(actualTime.toString());
	}

	@Test
	public void testGetTimeDifference() {
		LocalDateTime startTime = null;
		LocalDateTime endTime = null;
		Duration timeDifference = counter.getTimeDifference(startTime, endTime);
		Long seconds = timeDifference.getSeconds();
		LOGGER.info(seconds.toString());
	}

}
