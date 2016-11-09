package warehouse;

/**
 * 
 * @author tedherman
 *
 */

public interface Floor {
  // methods used mainly by Visualizer 
  // there should be more methods, so Visualizer can
  // learn where are Belt and ShelfAreas
  Point getPicker(); 
  Point getPacker(); 
  Point getShippingDock(); 
  Point getReceivingDock(); 
  Point getCharger();
  // method used by Inventory to stock items on shelves
  Point randomInShelfArea(); 
  }


