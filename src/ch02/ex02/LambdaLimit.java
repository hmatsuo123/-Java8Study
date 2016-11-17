package ch02.ex02;

import java.util.Arrays;
import java.util.List;

public class LambdaLimit {

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("loooooooongword", "shortword", "loooooooongword", "loooooooongword", "loooooooongword", "loooooooongword", "loooooooongword", "loooooooongword");
		wordList.stream().filter(word -> {
			System.out.println("filter: " + word);
			return word.length() > 10;
		}).limit(5).forEach(System.out::println);
	}
}
