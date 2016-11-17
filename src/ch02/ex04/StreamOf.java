package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {

	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		Stream<int[]> stream = Stream.of(values);
		stream.forEach(intArray -> {
			for (int i = 0; i < intArray.length; i++) {
				System.out.println(intArray[i]);
			}
		});

		IntStream intStream = IntStream.of(values);
		intStream.forEach(System.out::println);
	}
}
