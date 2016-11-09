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
	Point getPicker() { return picker; }
	Point getPacker() { return packer; }
	Point getShippingDock() { return shippingdock; }
	Point getReceivingDock() { return receivingdock; }
	Point getCharger() { return charger; }
	/**
	 * @return some random Point within a randomly 
	 * chosen shelfarea - might be useful for product
	 * distribution on shelves, returning a shelf to
	 * the shelfarea, etc.
	 */
	Point randomInShelfArea() {
	  int s = randogen.nextInt(shelfareas.size());
	  return shelfareas.get(s).randomPoint();
	  }
	  

/**
 * @author Ted Herman
 *
 */
class ShelfArea {
  int width; // height will always be 2 -- just two shelves
  Point corner;  // lower left corner of shelf area
  List<Point> contents;
  /**
   * @param corner - lower left corner of shelf area
   * @param width - how many squares wide shelf area is
   */
  ShelfArea(Point corner, int width) {
	contents = new ArrayList<Point>();
	this.corner = new Point(corner.x,corner.y);
	this.width = width;
	for (int i=corner.y; i<corner.y+2; i++)
	 for (int j=corner.x; j<corner.x+width; j++) {
	   contents.add(new Point(j,i));
       }
	populate();  // fill with shelves
    }
  /**
   * fill this shelfarea with Shelf objects at each Point;
   * this will be called by the constructor
   */
  void populate() {
	for (Point e: contents) {
	  e.setContents(new Shelf());
	  }
    }
  /**
   * @return true if point P is within this ShelfArea
   * @param P point to test
   */
  boolean within(Point P) {
	if (P.x < corner.x) return false;
	if (P.x >= corner.x + width) return false;
	if (P.y >= corner.y+2) return false;
	if (P.y < corner.y) return false;
	return true;
    }
  /**
   * @return true if point P has non-null content (robot or shelf)
   */
  boolean occupied(Point P) {
	if (within(P) && P.contents != null) return true;
	return false;
    }
  /**
   * @param Object to place in a Point
   * @note if Object is null, then makes Point P empty
   */
  void setContent(Point P, Object O) {
	if (!occupied(P) && within(P)) {
	  P.contents = O;	
	  }
    }
  /**
   * @return random Point within this shelfarea
   */
  Point randomPoint() {
	Random R = new Random();
	int column = R.nextInt(width);
	int row = R.nextInt(2);
	Point P = new Point(corner.x+column,corner.y-row);
	return P;
    }
 }
}


