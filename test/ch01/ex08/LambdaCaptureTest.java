package ch01.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdaCaptureTest {

	@Test
	public void testLambdaMethod() {
		try {
			new LambdaCapture().lambdaMethod();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testForLoopMethod() {
		try {
			new LambdaCapture().forLoopMethod();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
