package ch02.ex12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class WordCounter {

	public static void main(String [] args) {
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth", "6", "7", "8", "9", "10", "11"));
		AtomicInteger[] shortWords = new AtomicInteger[12];
		for (int i = 0; i < 12; i++) {
            shortWords[i] = new AtomicInteger();
        }

		arrayList.stream().parallel().forEach(s -> {
			if(s.length() < 12) {
				shortWords[s.length()].getAndIncrement();
			}
		});
		System.out.println(Arrays.toString(shortWords));
	}
}
