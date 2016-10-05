package clock;

import asteroidplugin1.handlers.AsteroidPlugin1Interface;

public class iClock implements AsteroidPlugin1Interface {
	
	private Clock clock;

	public iClock() {
	}

	@Override
	public void setPaused(boolean paused) {
		this.clock.setPaused(paused);		
	}

	@Override
	public void update() {
		this.clock.update();		
	}

	@Override
	public boolean hasElapsedCycle() {
		return this.clock.hasElapsedCycle();
	}

	@Override
	public boolean isPaused() {
		return this.clock.isPaused();
	}

	@Override
	public Clock NewObject(int frames_per_second) {
		this.clock = new Clock(frames_per_second);
		
		return this.clock;

	}

	@Override
	public Clock CurrentClock() {
		// TODO Auto-generated method stub
		return this.clock;
	}
}