package ch02.ex03;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ParallelStreamBenchTest {

	@Test
	public void testGetLongWordCountBench() {
		try {
			new ParallelStreamBench("." + File.separator + "src" + File.separator + "ch02" + File.separator + "ex03" + File.separator + "WarAndPeace.txt").getLongWordCountBench();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetLongWordCountParallelBench() {
		try {
			new ParallelStreamBench("." + File.separator + "src" + File.separator + "ch02" + File.separator + "ex03" + File.separator + "WarAndPeace.txt").getLongWordCountParallelBench();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
