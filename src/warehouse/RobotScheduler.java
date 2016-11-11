package warehouse;

/**
 * 
 * @author Ted Herman
 * 
 * This is the interface for making requests and
 * getting responses from Robots.  
 *
 */
public interface RobotScheduler {
  /**
   * @param s is a Shelf to bring to the picker location
   * @param p is a Picker interface to invoke when the shelf
   * has been delivered to the picker location
   */
  void requestShelf(Shelf s, Picker p);
  /**
   * the returnShelf() tells a Robot carrying a Shelf to 
   * put that Shelf back into a ShelfArea on the Floor
   */
  void returnShelf();
  }
