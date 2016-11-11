package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInventory {
  /**
   * Sanity test that Inventory created items and 
   * put them on the expected shelf
   */
  @Test
  public void test001() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	Inventory I = new MockInventory(F,randomsource);
	Item[] d = I.onShelf(new Point(34,100));
	assertEquals(d.length,1);
	assertEquals(d[0].id,547840);
    }
  /**
   * Test that an item is in stock, on an expected shelf
   */
  @Test
  public void test002() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	Inventory I = new MockInventory(F,randomsource);
	Shelf s = I.findItem(new Item(547840,
			"1-Cup Coffee and Espresso Maker"));
	assertTrue((s.home).equals(new Point(34,100)));
    }
  }