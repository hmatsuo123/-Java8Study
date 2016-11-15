package ch01.ex06;

import org.junit.Test;

public class UncheckRunnableTest {

	@Test
	public void testUncheck() {
		new Thread(UncheckRunnable.uncheck(() -> {
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

}
