package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DoInOrderAsync {

	public static <T> void doInOrderAsync(Supplier<? extends T> first, BiConsumer<? super T, ? super Throwable> second) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result, null);
                } catch (Throwable t) {
                    second.accept(null, t);
                }
            }
        };
        t.start();
    }

	public static <T> void doInOrderAsync2(Supplier<? extends T> first, BiConsumer<? super T, Throwable> second, Consumer<? super Throwable> handler) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result, null);
                } catch (Throwable t) {
                    handler.accept(t);
                    second.accept(null, t);
                }
            }
        };
        t.start();
    }

	public static void main(String[] args) throws Exception {
		Supplier<String> supplier = () -> {
			long id = Thread.currentThread().getId();
			if (id % 2 == 0) {
                return String.valueOf(id);
            } else {
                throw new RuntimeException("スレッドIDが奇数");
            }
        };
        BiConsumer<String, Throwable> consumer = (first, second) -> {
            if (second == null) {
                System.out.println(first);
            } else {
                System.err.println(second.getMessage());
            }
        };

        for (int i = 0; i < 20; i++) {
            doInOrderAsync(supplier, consumer);
        }
	}
}
