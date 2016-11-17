package warehouse;

/**
 * 
 * @author Ted Herman
 * 
 * A Bin contains an Order that has all its items ready to go
 *
 */
public class Bin {
  Order order;  // ready to go on the Belt
  boolean finished;  // initially false, becomes true when ready to go
  public Bin() { order = null; finished = false; }
  public boolean isFinished() { return finished; }
  public void setFinished() { finished = true; }
  public Order getOrder() { return order; }
  public void setOrder(Order o) { order = o; }
  public String toString() { return "Bin"; }
  }
