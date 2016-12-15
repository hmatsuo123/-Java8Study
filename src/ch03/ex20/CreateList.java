package ch03.ex20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreateList {

	public static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
		return list.stream().map(mapper::apply).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("first", "second", "third", "forth", "fifith");
		List<String> result = CreateList.map(list, (s) -> "[" + s + "]" );
		result.stream().forEach(System.out::println);
	}
}
