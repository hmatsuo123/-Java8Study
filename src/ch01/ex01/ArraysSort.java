package ch01.ex01;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args) {
		String[] words = new String[] {"123", "456"};
		System.out.println("main thread: " + Thread.currentThread().getId());
        Arrays.sort(words, (first, second) -> {
            System.out.println("sort thread: " + Thread.currentThread().getId());
            return Integer.compare(first.length(), second.length());
        });
	}
}
