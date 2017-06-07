package com.desktopmanager.logic;

import java.time.Duration;
import java.time.LocalDateTime;

public final class TimeCounter {
	private final LocalDateTime startTime;
	
	public TimeCounter() {
		startTime = LocalDateTime.now(); 
	}
	
	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getActualTime() {
		return LocalDateTime.now();
	}
	
	public Duration getTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
		return Duration.between(startTime, endTime);
	}

}
