package warehouse;

/**
 * 
 * @author Ted Herman
 * 
 * This is a class for an individual Robot (in theory,
 * a warehouse could have multiple Robot objects)
 */
public class Robot {
  Point location;  
  Shelf shelf; // null if not carrying a shelf
  public Robot(Point startlocation) {
	location = startlocation;
	shelf = null;
    }
  }
