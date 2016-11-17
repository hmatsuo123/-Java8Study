package ch02.ex09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class ArrayListCollectorTest {

	@Test
	public void test() {
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth"));
		ArrayList<String> result = new ArrayListCollector().collectArray(Stream.of(expected));
		assertEquals(expected, result);
	}

}
