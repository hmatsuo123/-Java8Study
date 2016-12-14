package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class WithLock {

	public static void withLock(ReentrantLock lock, Runnable runnable) {
        if (lock.isLocked())
            throw new IllegalStateException("指定されたlockは既にロックされてます。");

        lock.lock();
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }

	public static void main(String[] args) {
		WithLock.withLock(new ReentrantLock(), () -> System.out.println("test"));
	}
}
