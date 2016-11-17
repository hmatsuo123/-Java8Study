package ch02.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayListCollector<T> {

	// TODO: 第二引数と第三引数の違いは？
	public ArrayList<T> collectArray(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<>(),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                },
                (x, y) -> {
                    x.addAll(y);
                    return x;
                });
	}

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth"));
		arrayList.stream().forEach(System.out::println);
		ArrayList<String> result = new ArrayListCollector().collectArray(Stream.of(arrayList));
		result.stream().forEach(System.out::println);
	}
}
