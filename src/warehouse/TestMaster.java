package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaster {

  @Test
  public void test000() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	RobotScheduler R = new MockRobotScheduler(F);
	Belt B = new MockBelt(F);
	Visualizer V = new MockVisualizer(F);
	Inventory I = new MockInventory(F,randomsource);
	Orders O = new MockOrders(I,R,randomsource);
	Master T = new Master(F,R,I,O,B,V);
	T.Run(100);
	// right now this is so simple, there is no assertEquals
	// kind of thing to test
	}

  }
