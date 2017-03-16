package ch09.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabeledPointTest {

	@Test
	public void test() {
		LabeledPoint point1 = new LabeledPoint(1, 1, "1");
		LabeledPoint point1_2 = new LabeledPoint(1, 1, "1");
		LabeledPoint point1_3 = point1;
		LabeledPoint point5 = new LabeledPoint(5, 5, "5");

		assertTrue(point1.equals(point1_2));
		assertTrue(point1.equals(point1_3));
		assertFalse(point1.equals(point5));
		assertTrue(point1.hashCode() == point1_2.hashCode());
        assertTrue(point1.hashCode() != point5.hashCode());
	}

}
