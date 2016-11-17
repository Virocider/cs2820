package warehouse;

public class Main {

  public static void main(String[] args) {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	RobotScheduler R = new MockRobotScheduler(F);
	Belt B = new MockBelt(F);
	Visualizer V = new MockVisualizer(F);
	Inventory I = new MockInventory(F,randomsource);
	Orders O = new MockOrders(I,B,R,randomsource);
	Master T = new Master(F,R,I,O,B,V);
	T.Run(100);	
    }
  }
