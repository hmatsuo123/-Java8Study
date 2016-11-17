package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {

	public Stream<Character> getCharacterStream(String s) {
		return IntStream.range(0, s.length()).map(s::charAt).mapToObj(i -> (char)i);
	}

	public static void main(String[] args) {
		Stream<Character> stream = new CharacterStream().getCharacterStream("abcdefg");
		stream.forEach(System.out::println);
	}
}
