package ch02.ex06;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class CharacterStreamTest {

	@Test
	public void testGetCharacterStream() {
		Object[] expected = { 'a', 'b', 'c', 'd', 'e'};
		Stream<Character> stream = new CharacterStream().getCharacterStream("abcde");
		assertArrayEquals(expected, stream.toArray());
	}

}
