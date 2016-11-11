package warehouse;

import java.util.Random;

/**
 * 
 * @author Ted Herman
 * 
 * The SimRandom class is a wrapper around
 * java.util.Random, providing only the 
 * nextInt(bound) method -- returns a random
 * number between 0 and bound-1. The reason
 * for this class is that SimRandom is deterministic,
 * it gives the same numbers in any simulation run.
 * 
 * So, for testing, the "random" choice of Orders
 * and Inventory will be predictable, which is nice
 * for testing and debugging purposes.
 *
 */
public class SimRandom {
  Random R; // delegate randomness to java.util.Random
  public SimRandom() {
	R = new Random(1001L);  // give initial seed for determinism
    }
  public int nextInt(int bound) {
	return R.nextInt(bound);
    }
  }
