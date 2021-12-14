package service;

import java.time.Duration;
import java.time.Instant;

public class TimeService {
	private Instant start ;
	
	public TimeService() { 
		this.start = Instant.now();
	}
	
	public long getTimeInSeconds() {
		Instant end = Instant.now();
		return Duration.between(start, end).getSeconds();
	}

}
