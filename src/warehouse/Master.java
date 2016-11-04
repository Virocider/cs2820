package warehouse;

/**
 * 
 * @author Ted Herman
 *
 */
public class Master {
	Floor floor;
	Robot robot;
	Tickable robotTick;
	/**
	 * Constructor should build instance of all other components,
	 * save them in members above for later. Order of creating the
	 * components might be important, as some components need to
	 * know about the others at the time of their construction.
	 */
	public Master(Floor inf, Robot inr) {
		floor = inf;
		robot = inr; 
		robotTick = robot.getTickObserver();
	    }
	/**
	 * Run a simulation. This code would need to be generalized
	 * into providing a tick for all observers (like Visualizer,
	 * like Belt, etc -- yet to be written).
	 * 
	 * @input an integer limit on how many ticks to do
	 */
	public void Run(int limit) {
	  for (int i=0; i<limit; i++) {
		robotTick.tick(i);  
	  }		
		
	}

}
