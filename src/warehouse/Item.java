package warehouse;

/**
 * 
 * @author Ted Herman
 *
 */

public class Item {
  public int id;  // item number, like a warehouse SKU number
  public String description;   // text for the item
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
  /**
   * @author Ted Herman
   * @return Shelf for this Item
   */
  public Shelf getPlace() { return place; }
  public void setPlace(Shelf s) { place = s; }
  public boolean equals(Item other) {
	return (this.id == other.id && this.description == other.description);
    }
  }