package service;

import java.time.Duration;
import java.time.Instant;

public class TimeService {
	
	private Instant start ;
	private long lastTimeUpdate;
	
	public TimeService() { 
		this.start = Instant.now();
		this.lastTimeUpdate = 0;
	}
	
	public long getTimeInSeconds() {
		Instant end = Instant.now();
		return Duration.between(start, end).getSeconds();
	}
	
	public long getLastTimeUpdated() {
		return lastTimeUpdate;
	}
	
	public void setLastTimeUpdated(long lastTimeUpdated) {
		this.lastTimeUpdate = lastTimeUpdated;
	}

	public boolean shouldUpdateGravity(Integer gravityVelocity) {
		return this.getTimeInSeconds() % gravityVelocity == 0 &&
				this.getLastTimeUpdated() != this.getTimeInSeconds();
	}

}
