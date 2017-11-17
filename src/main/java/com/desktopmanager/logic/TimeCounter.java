package com.desktopmanager.logic;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Mariusz Czarny
 *
 */
public final class TimeCounter {
	
	private TimeCounter() {
	}

	public static String getActualTime() {
		return LocalDateTime.now().toString();
	}
	
	public Duration getTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
		return Duration.between(startTime, endTime);
	}

}
