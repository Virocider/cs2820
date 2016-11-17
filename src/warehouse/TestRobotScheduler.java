package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class TestRobotScheduler {
  // instance variables modified by all tests
  localPicker LP;
  SimRandom randomsource;
  Floor F;
  Inventory I;
  Belt B;
  RobotScheduler R;
  Orders O;
  Order someorder;
  OrderItem someitem;
  Shelf someshelf;
  
  /**
   * Local Class -- localPicker, just a Picker
   * which remembers a shelf and robot
   */
  class localPicker implements Picker {
	Shelf s = null;
	Robot r = null;
	public void notify(Robot r, Shelf s) {
	  // System.out.println("notified");
	  this.s = s; this.r = r;
	  }
    }
  
  @Before
  public void testSetup() {
	  LP = new localPicker();
	  randomsource = new SimRandom();
	  F = new MockFloor(randomsource);
	  B = new MockBelt(F);
	  I = new MockInventory(F,randomsource);
	  R = new MockRobotScheduler(F);
	  O = new MockOrders(I,B,R,randomsource);
	  someorder = O.getRandomOrder();
	  someitem = someorder.getUnfilledItem();
	  someshelf = I.findItem(someitem);
      }
  
  @Test
  /**
   * Can Robot fetch a shelf, bring it to Picker?
   */
  public void test001() {
	R.requestShelf(someshelf,LP);
	for (int i=0;i<1000;i++) {
	  ((Tickable)R).tick(i);
	  if (LP.r == null) continue; // wait for notify event
	  if (LP.r.state == Robot.atpicker) break;
	  }
	assertTrue(I.onShelf(someshelf)[0].equals(someitem));
	assertTrue(LP.r.location.equals(F.getPicker()));
	}
  
  @Test
  /**
   * Repeat test001, but then also can Robot take 
   * shelf back to its home location?
   */
  public void test002() {
	R.requestShelf(someshelf,LP);
	for (int i=0;i<1000;i++) {
	  ((Tickable)R).tick(i);
	  if (LP.r == null) continue; // wait for notify event
	  if (LP.r.state == Robot.atpicker) break;
	  }
	R.returnShelf(LP.r);
	for (int i=0;i<1000;i++) {
	  ((Tickable)R).tick(i);
	  if (LP.r.shelf == null) break;
	  }
	// location of robot should be at Shelf
	assertEquals(LP.s.home,LP.r.location);
	assertEquals(LP.r.shelf,null);
	Object tmp = F.getCell(LP.r.location).getContents();
	assertTrue(tmp instanceof Shelf);
	assertTrue(((Shelf)tmp).onFloor());
	assertEquals(LP.r.state,Robot.chargerbound);
    }
  
  @Test
  /**
   * Repeat test002, but then run until Robot gets back to charger
   */
  public void test003() {
	R.requestShelf(someshelf,LP);
	for (int i=0;i<1000;i++) {
	  ((Tickable)R).tick(i);
	  if (LP.r == null) continue; // wait for notify event
	  if (LP.r.state == Robot.atpicker) break;
	  }
	R.returnShelf(LP.r);
	for (int i=0;i<1000;i++) { ((Tickable)R).tick(i); }
	assertEquals(LP.r.state,Robot.idle);
	assertTrue(LP.r.location.equals(F.getCharger()));
    }
  }