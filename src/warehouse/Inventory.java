package warehouse;

/**
 * 
 * @author Ted Herman
 *
 */

public interface Inventory {
  Item[] onShelf(Shelf s); // items on Shelf s
  Item[] onShelf(Point p); // items on Shelf at Point p
  Item randomItem();       // some random item
  Shelf findItem(Item e);  // find a shelf that has this Item
  int stockCount(Item x);  // quantity of x that's in stock
  int stockCount(int ItemNum);  // quantity in stock of Item #
  Item removeItem(Item I,Shelf s); // remove Item from Shelf
  }
