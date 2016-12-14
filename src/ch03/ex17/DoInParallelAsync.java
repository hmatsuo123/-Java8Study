package ch03.ex17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class DoInParallelAsync {

	public static <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<? super Throwable> handler) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.submit(() -> {
			try {
				first.run();
			} catch (Throwable t) {
				handler.accept(t);
			}
		});
		pool.submit(() -> {
			try {
				second.run();
			} catch (Throwable t) {
				handler.accept(t);
			}
		});
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.HOURS);
	}

	public static void main(String[] args) throws InterruptedException {
		doInParallelAsync(() -> System.out.println("first: " + Thread.currentThread().getId()),
				() -> System.out.println("second: " + Thread.currentThread().getId()),
				(t) -> System.err.println("Throwable: " + t.getMessage()));
	}
}
