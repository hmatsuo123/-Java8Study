package ch01.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class AndThenTest {
	boolean isExeFirstRun = false;
	@Test
	public void testAndThen() {
		isExeFirstRun = false;
		Runnable run = new AndThen().andThen(() -> {
			try {
				Thread.sleep(1000);
				isExeFirstRun = true;
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}, () -> {
			assertEquals(true, isExeFirstRun);
		});
		new Thread(run).start();
	}

}
