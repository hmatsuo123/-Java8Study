package ch03.ex02;

import static org.junit.Assert.*;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class WithLockTest {

	@Test(expected = NullPointerException.class)
    public void testWithLock_NullPointerException() {
        WithLock.withLock(null, () -> System.out.println("test"));
    }

    @Test(expected = NullPointerException.class)
    public void testWithLock_NullPointerException2() {
        WithLock.withLock(new ReentrantLock(), null);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithLock_IllegalStateException() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        WithLock.withLock(lock, () -> System.out.println("test"));
    }

    @Test
    public void testWithLock() {
        try {
        	WithLock.withLock(new ReentrantLock(), () -> System.out.println("test"));
        }
        catch (Exception e) {
        	fail(e.getMessage());
        }
    }
}
