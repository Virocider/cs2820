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
}
