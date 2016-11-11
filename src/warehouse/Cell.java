package warehouse;

/**
 * 
 * @author Ted Herman
 * Cell is an extension (subclass) of Point which also has 
 * possible content (a Robot or Shelf). Floor should be "in charge"
 * of having all the Cell objects, and Robot, Orders, Inventory, 
 * maybe even Belt should update Cell objects using methods of Floor
 *
 */
public class Cell extends Point {
  public Object contents;
  Cell(int x, int y) {
	super(x,y); contents = null;
	}
  Object getContents() {
	return contents;
    }
  void setContents(Object O) {
	contents = O;  
    }
  /**
   * Display Cell as a string
   */
  public String toString() {
    String result = super.toString();
    if (contents instanceof Robot) result += " contains Robot";
    if (contents instanceof Shelf) result += " contains Shelf";
    return result;
    }
  }
