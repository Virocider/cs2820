package warehouse;

public class Order {
  String address;
  OrderItem[] orderitems;
  boolean isFilled;
  /**
   * @author Ted Herman
   * @param addr is a shipping address for the order
   * @param items is an array of OrderItem objects
   */
  public Order(String addr,OrderItem[] items) {
	address = addr;
	orderitems = items;
	isFilled = false;
    }
  public OrderItem getUnfilledItem() {
	for (OrderItem e: orderitems) {
	  if (e.inBin) continue;
	  return e;
	  }
	isFilled = true;  // because all OrderItems are in bin
	return null; // if no needed OrderItem can be found
    }
  }