package warehouse;

import java.util.*;

/**
 * 
 * @author Ted Herman
 *
 */
public class MockFloor implements Floor {
  /**
   * A fake Floor component for testing purposes only
   */
  static final int warehousewidth = 160;
  static final int warehousedepth = 200;

  final Point picker = new Point(0,10);
  final Point packer = new Point(0,150);
  final Point shippingdock = new Point(0,0);
  final Point receivingdock = new Point(80,0);
  final Point charger = new Point(20,20);

  List<ShelfArea> shelfareas;
  Random randogen;

  public MockFloor() {
    randogen = new Random();
    shelfareas = new ArrayList<ShelfArea>();
    shelfareas.add(new ShelfArea(new Point(20,100),160));
    shelfareas.add(new ShelfArea(new Point(20,200),160));
    shelfareas.add(new ShelfArea(new Point(20,300),160));
    }
  /**
   * @author Ted Herman
   * methods to return known locations in warehouse
   */ 
  public Point getPicker() { return picker; }
  public Point getPacker() { return packer; }
  public Point getShippingDock() { return shippingdock; }
  public Point getReceivingDock() { return receivingdock; }
  public Point getCharger() { return charger; }
  public int getNumShelfAreas() { 
	return shelfareas.size();
    }
  public ShelfArea getShelfArea(int which) {
	return shelfareas.get(which);
    }
  
  /**
   * @return some random Point within a randomly 
   * chosen shelfarea - might be useful for product
   * distribution on shelves, returning a shelf to
   * the shelfarea, etc.
   */
  public Point randomInShelfArea() {
    int s = randogen.nextInt(shelfareas.size());
    return shelfareas.get(s).randomPoint();
    }
}
