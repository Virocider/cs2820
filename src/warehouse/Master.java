package warehouse;

/**
 * 
 * @author Ted Herman
 * The Master class runs the simulated warehouse. It creates
 * initial instances of Floor, Robot, Inventory, Orders, Belt,
 * and Vizualizer. It has a method to generate "tick" events
 * to all the Tickable components, and it should also provide
 * a scheduled Event service (not yet coded).
 *
 */
public class Master {
	Floor floor;
	Robot robot;
	Inventory inventory;
	Orders orders;
	/**
	 * Constructor should build instance of all other components,
	 * save them in members above for later. Order of creating the
	 * components might be important, as some components need to
	 * know about the others at the time of their construction.
	 */
	public Master(Floor inf, Robot inr,
			Inventory ini, Orders ino) {
		floor = inf;
		robot = inr; 
		inventory = ini;
		orders = ino;
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
		Tickable t = (Tickable) robot;
		t.tick(i);  
	  }		
		
	}

}
