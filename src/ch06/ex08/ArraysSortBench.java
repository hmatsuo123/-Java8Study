package ch06.ex08;

import java.util.Arrays;
import java.util.Random;

public class ArraysSortBench {
	private static int count = 3;

	public static void sort(String[] words) {
		long startTime;
		long sum = 0;
		for (int i = 0; i < count; i++) {
			startTime = System.nanoTime();
	        Arrays.sort(words);
	        sum += System.nanoTime() - startTime;
		}
        System.out.println("Single: Array size=" + words.length + ", Time=" + sum / count / 1000000000f + "[sec]");
    }

    public static void sortParallel(String[] words) {
    	long startTime;
		long sum = 0;
		for (int i = 0; i < count; i++) {
			startTime = System.nanoTime();
	        Arrays.parallelSort(words);
	        sum += System.nanoTime() - startTime;
		}
        System.out.println("Maluti: Array size=" + words.length + ", Time=" + sum / count / 1000000000f + "[sec]");
    }

    public static void main(String[] args) {
    	String[] array = new String[5000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = Double.toString(random.nextDouble());
		}

		ArraysSortBench.sort(array.clone());
		ArraysSortBench.sortParallel(array.clone());
    }
}

/*
 * Single: Array size=5000, Time=0.001624004[sec]
 * Maluti: Array size=5000, Time=0.001515038[sec]
 * */
