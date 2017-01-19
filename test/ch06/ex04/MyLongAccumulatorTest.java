package ch06.ex04;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyLongAccumulatorTest {

	@Test
	public void testMax() {
		List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L);
    	assertEquals(8L, MyLongAccumulator.max(list));
	}

	@Test
	public void testMin() {
		List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L);
    	assertEquals(1L, MyLongAccumulator.min(list));
	}

}
