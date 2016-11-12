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
  public static final int pickerdone = 3;
  public static final int dockshelfbound = 4;
  public static final int dockbound = 5;
  public static final int dockdone = 6;
  public static final int chargerbound = 7;
  
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
  }
