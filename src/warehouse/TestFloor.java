package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFloor {

  @Test
  /**
   * Test that Floor knows where Picker is
   */
  public void test001() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	assertTrue((F.getPicker()).equals(new Point(0,10)));
	}
  /**
   * Test that Floor returns "random" points in shelfarea
   * This is a predictable test because SimRandom is predictable,
   * so we can test this. But, it may not work for newer Java
   * versions which change how Random works.
   */
  @Test
  public void test002() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	System.out.println(F.getCell(158,100));
	assertTrue((F.randomInShelfArea()).equals(new Point(123,299)));
	assertTrue((F.randomInShelfArea()).equals(new Point(71,299)));
	assertTrue((F.randomInShelfArea()).equals(new Point(22,99)));
    }
  /**
   * Test if Point (158,100) contains a Shelf, as expected
   */
  public void test003() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	Cell C = F.getCell(158,100);
	Object O = C.getContents();
	assertTrue(O instanceof Shelf);
    }

  }
