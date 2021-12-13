package service;

import java.time.Duration;
import java.time.Instant;

public class TimeService {
	private Instant start ;
	private long startTime;
	
	public TimeService() { 
		this.startTime = System.currentTimeMillis();
		this.start = Instant.now();
	}
	
	public Duration getActualDuration() { 
		Instant end = Instant.now();
		return Duration.between(start, end);
	}
	
	public long getTime() {
		long now = System.currentTimeMillis();
		return startTime - now;
	}

}
