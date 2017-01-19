package ch06.ex03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class AtomicBench {
	private static final int THREADCOUNT = 1000;
	private static final int COUNT = 100000;

	public static void printAtomicLong() {
		AtomicLong count = new AtomicLong(0);
		CountDownLatch latch = new CountDownLatch(THREADCOUNT);
		ExecutorService pool = Executors.newCachedThreadPool();
		long startTime = System.nanoTime();
		for (int i = 0; i < THREADCOUNT; i++) {
		    pool.submit(
		        () -> {
		            for (int j = 0; j < COUNT; j++) {
		                count.incrementAndGet();
		            }
		            latch.countDown();
		        }
		    );
		}
		pool.shutdown();
		try {
			latch.await();
			System.out.println("AtomicLong: Count=" + count + ", Time=" + (System.nanoTime() - startTime) / 1000000000f + "[sec]");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void printAtomicLong(int threadCount) {
		AtomicLong count = new AtomicLong(0);
		CountDownLatch latch = new CountDownLatch(THREADCOUNT);
		ExecutorService pool = Executors.newFixedThreadPool(threadCount);
		long startTime = System.nanoTime();
		for (int i = 0; i < THREADCOUNT; i++) {
		    pool.submit(
		        () -> {
		            for (int j = 0; j < COUNT; j++) {
		                count.incrementAndGet();
		            }
		            latch.countDown();
		        }
		    );
		}
		pool.shutdown();
		try {
			latch.await();
			System.out.println("AtomicLong: Thread=" + threadCount + ", Count=" + count + ", Time=" + (System.nanoTime() - startTime) / 1000000000f + "[sec]");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void printLongAdder() {
		LongAdder adder = new LongAdder();
		CountDownLatch latch = new CountDownLatch(THREADCOUNT);
		ExecutorService pool = Executors.newCachedThreadPool();
		long startTime = System.nanoTime();
		for (int i = 0; i < THREADCOUNT; i++) {
		    pool.submit(
		        () -> {
		            for (int j = 0; j < COUNT; j++) {
		            	adder.increment();
		            }
		            latch.countDown();
		        }
		    );
		}
		pool.shutdown();
		try {
			latch.await();
			System.out.println("LongAdder:  Count=" + adder + ", Time=" + (System.nanoTime() - startTime) / 1000000000f + "[sec]");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void printLongAdder(int threadCount) {
		LongAdder adder = new LongAdder();
		CountDownLatch latch = new CountDownLatch(THREADCOUNT);
		ExecutorService pool = Executors.newFixedThreadPool(threadCount);
		long startTime = System.nanoTime();
		for (int i = 0; i < THREADCOUNT; i++) {
		    pool.submit(
		        () -> {
		            for (int j = 0; j < COUNT; j++) {
		            	adder.increment();
		            }
		            latch.countDown();
		        }
		    );
		}
		pool.shutdown();
		try {
			latch.await();
			System.out.println("LongAdder:  Thread=" + threadCount + ", Count=" + adder + ", Time=" + (System.nanoTime() - startTime) / 1000000000f + "[sec]");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AtomicBench.printAtomicLong();
		AtomicBench.printLongAdder();
		AtomicBench.printAtomicLong(1);
		AtomicBench.printLongAdder(1);
		AtomicBench.printAtomicLong(2);
		AtomicBench.printLongAdder(2);
	}
}
