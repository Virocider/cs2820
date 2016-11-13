package warehouse;
import java.util.*;
/**
 * @author Ted Herman
 * Crude sketch of a Visualizer component. It only implements tick()
 * and has no other public methods. In a real visualizer, there would
 * be GUI display of the warehouse. It could be done using Java Spring
 * framework, or it could be done by making a webpage and then telling
 * a browser, at each tick, to display that web page.
 */
public class MockVisualizer implements Visualizer, Tickable {
  Floor F;
  List<Point> allPoints;
  Map<Point,Cell> previousCells;
  /**
   * @author Ted Herman
   * @param F is the Floor - visualizer gets all its information
   * from the floor, including locations of moving things like
   * robots and shelves.
   */
  public MockVisualizer(Floor F) { 
	this.F = F; 
	// this might be a place to write code that sets up Swing or
	// some output GUI, even a webpage that a regular browser like
	// Firefox could display
	setup();
	}
  /**
   * initialize instance variables by asking Floor for lots
   * of informtion about the warehouse
   */
  private void setup() {
	// allPoints is a useful list of all points in warehouse
	allPoints = new ArrayList<Point>();
	for (int i=0;i<F.getWarehouseWidth();i++)
	  for (int j=0;j<F.getWarehouseDepth();j++)
		allPoints.add(new Point(i,j));
	// print information about the warehouse
	System.out.println("Warehouse dimension is "+F.getWarehouseWidth()+"x"+
	            F.getWarehouseDepth());
	System.out.print("Belt information:");
	System.out.print(" Picker at "+F.getPicker());
	System.out.print(" Packer at "+F.getPacker());
	System.out.println(" Shipping Dock at "+F.getShippingDock());
	System.out.println("Charger at "+F.getCharger());
	System.out.println("Receiving Dock at "+F.getReceivingDock());
    for (int i=0;i<F.getNumShelfAreas();i++) {
      System.out.print("Self Area "+i);
      ShelfArea s = F.getShelfArea(i);
      System.out.print(" lower left corner at "+s.getCorner());
      System.out.println(" dimension "+s.getWidth()+"x"+s.getHeight());
      }
	// record initial copy of all Floor's cells
    previousCells = cloneAllCells();
    }
  /**
   * Local method to make a copy of all Cells in the Floor
   * so that in each tick, it's easy to see what has changed
   * @return list of all Cell objects in Floor
   */
  private Map<Point,Cell> cloneAllCells() {
	Map<Point,Cell> L = new HashMap<Point,Cell>();
	for (Point p: allPoints) {
	  L.put(p,F.getCell(p));
	  }
	return L;
    }
  /**
   * Tick method just prints time and what has changed since the 
   * previous tick, if anything
   */
  public void tick(int count) {
	String display = "Tick %d";
	System.out.println(String.format(display,count));  
	Map<Point,Cell> newcells = cloneAllCells();
	for (Point p: allPoints) {
	  Cell c = newcells.get(p);
	  // skip over cells that are empty, or have same as what we saw previously
	  if (c.getContents()==null) continue; 
	  if (c.getContents()==previousCells.get(p).getContents()) continue;
	  if (c.getContents() instanceof Robot) 
		System.out.println(c);
	  if (c.getContents() instanceof Shelf)
		System.out.println(c);
      }
	// done with tick, save newcells for next time in previousCells
	previousCells = newcells;
    }
  }