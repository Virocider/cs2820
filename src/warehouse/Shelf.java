package warehouse;


/**
 * 
 * @author Ted Herman
 */
public class Shelf {
  final int capacity = 5;  // max number of allowable items
  Point home;              // home location of shelf
  public Shelf(Point home) {
	this.home = new Point(home.x,home.y);
    }
  }