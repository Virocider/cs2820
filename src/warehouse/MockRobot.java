package warehouse;

/**
 * 
 * @author Ted Herman
 *
 */
public class MockRobot implements Robot, Tickable {
   /**
    * Constructor - currently has no input or output
    */
   public MockRobot() {   
   }
   /**
    * getTickObserver provides caller something to 
    * invoke for a tick() event -- just this object!
    */
   public Tickable getTickObserver() {
	   return this;
   }
   /**
    * tick(int time) is required by Tickable, called at
    * every time unit by the Master
    */
   public void tick(int time) {   
   }
}
