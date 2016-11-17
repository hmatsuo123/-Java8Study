package ch02.ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

	public static void main(String [] args) {
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth", "6", "7", "8", "9", "10", "11"));
		Map<Integer, Long> map = arrayList.parallelStream().filter(w -> w.length() < 12).collect(Collectors.groupingBy(String::length, Collectors.counting()));

		for(Map.Entry<Integer, Long> e : map.entrySet()) {
			System.out.println("文字数：" + e.getKey() + ", 単語数：" + e.getValue());
		}
	}
}
