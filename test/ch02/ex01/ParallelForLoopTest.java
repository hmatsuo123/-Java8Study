package ch02.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParallelForLoopTest {

	@Test
	public void testGetLongWordCount() {
		ParallelForLoop pfl = new ParallelForLoop();
		int sum = pfl.getLongWordCount("test1test2ttt");
		assertEquals(2, sum);
	}

}
