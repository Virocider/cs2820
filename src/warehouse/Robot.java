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
  // some static "enum"-like values for Robot state
  // "pickerbound" means on the way to Picker location
  // "pickerdone" means on the way to put Shelf back after Picker
  public static final int idle = 0;
  public static final int pickershelfbound = 1;
  public static final int pickerbound = 2;
  public static final int atpicker = 3;
  public static final int afterpickershelfbound = 4;
  public static final int dockshelfbound = 5;
  public static final int dockbound = 6;
  public static final int atdock = 7;
  public static final int afterdockshelfbound = 8;
  public static final int chargerbound = 9;
  
  Point location;
  List<Point> path;  // path of Points to travel
  Shelf shelf; // null if not carrying a shelf
  int state;   // one of the values above, like "idle"
  Picker picker;  // only used for going to picker
  Dock dock;      // only used for going to dock
  public Robot(Point startlocation) {
	location = startlocation;
	path = null;
	shelf = null;
	state = idle;
	picker = null;
	dock = null;
    }
  public String toString() {
	return String.format("Robot at %s with state %d",location,state);  
    }
  }
