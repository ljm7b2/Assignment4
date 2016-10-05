package asteroidplugin1.handlers;
import clock.Clock;


public interface AsteroidPlugin1Interface {
	
	Clock NewObject(int frames_per_second);
	boolean isPaused();
	void setPaused(boolean paused);
	void update();
	boolean hasElapsedCycle();
	Clock CurrentClock();

}
