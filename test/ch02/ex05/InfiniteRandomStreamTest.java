package ch02.ex05;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class InfiniteRandomStreamTest {

	@Test
	public void testRandom() {
		try {
			Stream<Long> stream = new InfiniteRandomStream().random(25214903917L, 11, (long)Math.pow(2, 48), 1L);
	        stream.limit(10).forEach(System.out::println);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
