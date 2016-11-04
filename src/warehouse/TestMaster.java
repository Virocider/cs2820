package warehouse;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaster {

	@Test
	public void test000() {
		Robot R = new MockRobot();
		Floor F = new MockFloor();
		Master T = new Master(F,R);
		T.Run(10);
		// right now this is so simple, there is no assertEquals
		// kind of thing to test
	}

}
