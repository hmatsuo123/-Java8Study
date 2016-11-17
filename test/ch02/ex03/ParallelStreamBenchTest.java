package ch02.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParallelStreamBenchTest {

	@Test
	public void testGetLongWordCountBench() {
		try {
			new ParallelStreamBench(".\\src\\ch02\\ex03\\WarAndPeace.txt").getLongWordCountBench();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetLongWordCountParallelBench() {
		try {
			new ParallelStreamBench(".\\src\\ch02\\ex03\\WarAndPeace.txt").getLongWordCountParallelBench();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
