package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaster {

	@Test
	public void test000() {
		Floor F = new MockFloor();
		RobotScheduler R = new MockRobotScheduler(F);
		Inventory I = new MockInventory(F);
		Orders O = new MockOrders(I);
		Master T = new Master(F,R,I,O);
		T.Run(10);
		// right now this is so simple, there is no assertEquals
		// kind of thing to test
	}

}
