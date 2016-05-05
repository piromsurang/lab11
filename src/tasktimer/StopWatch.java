package tasktimer;

/**
 * 
 * computing elapsed time
 * @author Piromsurang
 *
 */
public class StopWatch {
	private long startTime;
	private long stopTime;
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void stop() {
		stopTime = System.nanoTime();
	}
	
	public double getElaspsed() {
		return stopTime - startTime;
	}
}
