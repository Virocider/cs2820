package warehouse;

public class MockRobotScheduler implements RobotScheduler, Tickable {
	
  Floor F;
  Robot[] robots; // someday could be two or more robots
	
  /**
   * @author Ted Herman
   * @param Floor object.
   * Floor is needed to find location of charger, etc.
   */
  public MockRobotScheduler(Floor F) {
	this.F = F;
	robots = new Robot[1];
	robots[0] = new Robot(F.getCharger()); // initially at the charger
    }
	
  /**
   * @author Ted Herman
   * 
   * The tick() method is where the real work would be done,
   * see the design README document	
   */
  public void tick(int count) { 
	// Look to see if any Robot should move
	for (Robot e: robots) {
	   if (e.path != null) moveRobot(e);
	   }
    };	
  /**
   * @param r is a Robot to move along its path, and if
   * the Robot reaches the end of the path, then decide
   * on where it should go next (if anywhere).
   */
  private void moveRobot(Robot r) { 
	if (r.path.size()>1) {
	   r.path.remove(0);  // remove first point in path
	   return;
	   }
	// when path has one Point, we arrive in this tick to target
	Point goal = r.path.get(0);
	r.path = null;
	if (goal.equals(F.getPicker())) {
	   r.picker.notify(r,r.shelf);
	   return;	
	   }
	if (goal.equals(F.getReceivingDock())) {
	   r.dock.notify(r,r.shelf);
	   return;
	   }
	if (goal.equals(F.getCharger())) {
	   r.inuse = false;
	   return;
	   }
	if (goal.equals(r.shelf.home)) {
	   r.shelf.putdown();  // Shelf is back home
	   r.shelf = null;
	   r.path = F.getPath(goal,F.getCharger()); 
	   return;
	   }
    }
  
  /**
   * @param s is a Shelf to fetch and bring to the picker
   * location (which the Floor knows)
   * @param p is a Picker interface, implemented by Orders,
   * which invoked this method - p is essentially a 
   * "callback" object to notify Orders at some later tick()
   */
  public void requestShelf(Shelf s, Picker p) { 
	Point target = s.home; // where Shelf sits
	Robot robot = findRobot(); // get some idle robot
	robot.path = F.getPath(robot.location,F.getPicker());
	robot.inuse = true;
	robot.picker = p;
    };
  /**
   * @param s is a Shelf to fetch and bring to the receiving
   * dock location (which the Floor knows)
   * @param d is a Dock interface, implemented by Inventory,
   * which invoked this method. The d parameter is thus a
   * "callback" object to notify Inventory at some later tick()
   */
  public void requestShelf(Shelf s, Dock d) { };
  /**
   * Command to return a robot carrying a shelf back to 
   * a ShelfArea on the Floor and put it down. Then the 
   * @param r is a Robot which is carrying a Shelf
   */
  public void returnShelf(Robot r) { };
  /**
   * find an available Robot (which is not in use)
   */
  private Robot findRobot() {
	// currently there is only one robot, this is trivial
	Robot r = robots[1];
	assert !r.inuse;
	assert r.shelf == null;
	return r;
    }
  }
