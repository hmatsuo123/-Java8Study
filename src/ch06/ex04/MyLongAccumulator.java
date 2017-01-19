package ch06.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

public class MyLongAccumulator {
	public static long max(List<Long> list) {
        LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);
        list.stream().parallel().forEach(max::accumulate);
        return max.get();
    }

    public static long min(List<Long> list) {
        LongAccumulator max = new LongAccumulator(Long::min, Long.MAX_VALUE);
        list.stream().parallel().forEach(max::accumulate);
        return max.get();
    }

    public static void main(String[] args) {
    	List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L);
    	System.out.println("Max:" + MyLongAccumulator.max(list));
    	System.out.println("Max:" + MyLongAccumulator.min(list));
    }
}
