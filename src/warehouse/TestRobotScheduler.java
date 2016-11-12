package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRobotScheduler {
  /**
   * Sanity test that Inventory created items and 
   * put them on the expected shelf
   */
  class localPicker implements Picker {
	Shelf s;
	Robot r;
	public void notify(Robot r, Shelf s) {
	  System.out.println("notified");
	  this.s = s; this.r = r;
	  }
    }
  @Test
  public void test001() {
	localPicker LP = new localPicker();
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	Inventory I = new MockInventory(F,randomsource);
	RobotScheduler R = new MockRobotScheduler(F);
	Orders O = new MockOrders(I,R,randomsource);
	Order someorder = O.getRandomOrder();
	OrderItem t = someorder.getUnfilledItem();
	Shelf s = I.findItem(t);
	R.requestShelf(s,LP);
	for (int i=0;i<4;i++) ((Tickable)R).tick(i);
	assertTrue(I.onShelf(s)[0].equals(t));
	assertTrue(LP.r.location.equals(F.getPicker()));
	}
  }