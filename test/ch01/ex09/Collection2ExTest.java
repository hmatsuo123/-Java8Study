package ch01.ex09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class Collection2ExTest {

	private static ArrayList<String> arrayList;
	private static Collection2Ex<String> collection2Ex;

	@Before
	public void initializeBeforeExecuteTestMethod() throws Exception {
		arrayList = new ArrayList<>();
		collection2Ex = new Collection2Ex<>();
		arrayList.addAll(Arrays.asList("first", "second", "third"));
		try {
			collection2Ex.addAll(Arrays.asList("first", "second", "third"));
		} catch (Exception e) {
			fail("Failed to addAll: " + e.getMessage());
		}
	}

	int count = 0;
	@Test
	public void testForEachIf() {
		count = 0;
		collection2Ex.forEachIf((t) -> count++, t -> t.contains("ir"));
		assertEquals(2, count);
	}

	@Test
	public void testSize() {
		assertEquals(arrayList.size(), collection2Ex.size());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(arrayList.isEmpty(), collection2Ex.isEmpty());
	}

	@Test
	public void testContains() {
		assertEquals(arrayList.contains("first"), collection2Ex.contains("first"));
	}

	@Test
	public void testIterator() {
		assertEquals(arrayList.iterator().next(), collection2Ex.iterator().next());
	}

	@Test
	public void testToArray() {
		assertArrayEquals(arrayList.toArray(), collection2Ex.toArray());
	}

	@Test
	public void testAddAndContainsAll() {
		assertEquals(arrayList.add("fourth"), collection2Ex.add("fourth"));
		assertEquals(arrayList.containsAll(Arrays.asList("first", "second", "third", "fourth")), collection2Ex.containsAll(Arrays.asList("first", "second", "third", "fourth")));
	}

	@Test
	public void testRemove() {
		assertEquals(arrayList.remove("first"), collection2Ex.remove("first"));
	}

	@Test
	public void testRemoveAll() {
		assertEquals((arrayList.removeAll(Arrays.asList("first", "second"))), collection2Ex.removeAll(Arrays.asList("first", "second")));
	}

	@Test
	public void testRetainAll() {
		assertEquals((arrayList.retainAll(Arrays.asList("first"))), collection2Ex.retainAll(Arrays.asList("first")));
	}

	@Test
	public void testClear() {
		arrayList.clear();
		collection2Ex.clear();
		assertEquals(arrayList.isEmpty(), collection2Ex.isEmpty());
	}

}
