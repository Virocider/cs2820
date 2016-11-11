package warehouse;

public class MockRobotScheduler implements RobotScheduler, Tickable {
	
  Floor F;
  Robot robot; // someday could be two or more robots
	
  /**
   * @author Ted Herman
   * @param Floor object.
   * Floor is needed to find location of charger, etc.
   */
  public MockRobotScheduler(Floor F) {
	this.F = F;
	robot = new Robot(F.getCharger()); // initially at the charger
    }
	
  /**
   * @author Ted Herman
   * 
   * The tick() method is where the real work would be done,
   * see the design README document	
   */
  public void tick(int count) { };	
  
  /**
   * some methods not yet done, called by Orders component
   */
  public void requestShelf(Shelf s, Picker p) { };
  public void returnShelf() { };
}
