package warehouse;
import java.util.*;
/**
 * 
 * @author Ted Herman
 * 
 * This is a class for an individual Robot (in theory,
 * a warehouse could have multiple Robot objects)
 */
public class Robot {
  Point location;
  List<Point> path;  // path of Points to travel
  Shelf shelf; // null if not carrying a shelf
  boolean inuse;  // true if Robot is busy
  Picker picker;  // only used for going to picker
  Dock dock;      // only used for going to dock
  public Robot(Point startlocation) {
	location = startlocation;
	path = null;
	shelf = null;
	inuse = false;
	picker = null;
	dock = null;
    }
  }
