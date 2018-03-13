package com.desktopmanager.logic;

import static com.desktopmanager.constant.DefaultValues.TIME_FORMAT;
import static com.desktopmanager.constant.DefaultValues.DATE_FORMAT;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Mariusz Czarny
 *
 */
public final class TimeCounter {
	
	private TimeCounter() {
	}

	public static String getActualTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT.getValue());
		return LocalDateTime.now().toLocalTime().format(formatter);
	}
	
	public static String getActualDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT.getValue());
		return LocalDateTime.now().format(formatter);
	}
	
	public Duration getTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
		return Duration.between(startTime, endTime);
	}

}
