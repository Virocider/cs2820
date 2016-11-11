package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaster {

  @Test
  public void test000() {
	SimRandom randomsource = new SimRandom();
	Floor F = new MockFloor(randomsource);
	RobotScheduler R = new MockRobotScheduler(F);
	Inventory I = new MockInventory(F,randomsource);
	Orders O = new MockOrders(I,randomsource);
	Master T = new Master(F,R,I,O);
	T.Run(10);
	// right now this is so simple, there is no assertEquals
	// kind of thing to test
	}

  }
