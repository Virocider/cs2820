package warehouse;

/**
 * 
 * @author Ted Herman
 * 
 * The Picker interface is implemented by the Orders
 * component; when a Robot arrives to the Picker, it 
 * invokes Picker.notify(robot) to tell the Orders that the
 * requested Robot has arrived.
 * 
 */
public interface Picker {
  void notify(Robot r);
  }
