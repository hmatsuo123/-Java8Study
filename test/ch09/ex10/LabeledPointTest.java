package ch09.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabeledPointTest {

	@Test
	public void testCompareTo() {
		LabeledPoint point1 = new LabeledPoint(1, 1, "1");
        LabeledPoint point1_2 = new LabeledPoint(1, 1, "1");
        LabeledPoint point5 = new LabeledPoint(5, 5, "5");
        LabeledPoint point5_2 = new LabeledPoint(5, 5, "555");

        assertTrue(point1.compareTo(point1_2) == 0);
        assertTrue(point1_2.compareTo(point1) == 0);
        assertTrue(point1.compareTo(point5) < 0);
        assertTrue(point5.compareTo(point1) > 0);
        assertTrue(point5.compareTo(point5_2) < 0);
	}

}
