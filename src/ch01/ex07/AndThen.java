package ch01.ex07;

public class AndThen {

	public Runnable andThen(Runnable first, Runnable second) {
		Thread thread1 = new Thread(first);
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			System.err.println(e);
		}

		return second;
	}

	public static void main(String[] args) {
		Runnable run = new AndThen().andThen(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("execute Run first.");
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}, () -> {
			System.out.println("execute Run second.");
		});
		new Thread(run).start();
	}
}
