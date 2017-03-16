package ch09.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
	Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
    Point p2 = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);

	@Test
	public void testSafeCompareTo() {
        assertTrue(p1.safeCompareTo(p2) > 0);
	}

	@Test
    public void testUnsafeCompareTo() {
        assertFalse(p1.unsafeCompareTo(p2) > 0);
    }

}
