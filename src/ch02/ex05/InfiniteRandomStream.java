package ch02.ex05;

import java.util.stream.Stream;

public class InfiniteRandomStream {

	public Stream<Long> random(long a, long c, long m, long seed) {
        return Stream.iterate(seed,  (x) -> (a * x + c) % m);
    }

	public static void main(String[] args) {
		Stream<Long> stream = new InfiniteRandomStream().random(25214903917L, 11, (long)Math.pow(2, 48), 1L);
        stream.limit(10).forEach(System.out::println);
	}
}
