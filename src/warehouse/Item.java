package warehouse;

/**
 * 
 * @author Ted Herman
 *
 */

public class Item {
  int id;  // item number, like a warehouse SKU number
  String description;   // text for the item
  Shelf place;  // where this item resides (or null)
  /**
   * @param num
   * @param title
   * Create a new Item object with given number and description
   */
  public Item(int num, String title) {
	place = null;
	id = num;
	description = title;
    }
  public Shelf getPlace() { return place; }
  public void setPlace(Shelf s) { place = s; }
  }
