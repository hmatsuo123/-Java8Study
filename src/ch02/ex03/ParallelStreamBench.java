package ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamBench {

	private final int minWordLength = 12;
	private List<String> wordList;

	public ParallelStreamBench(String FilePath) {
		try {
			String contents = new String(Files.readAllBytes(Paths.get(FilePath)), StandardCharsets.UTF_8);
			wordList = Arrays.asList(contents.split("[\\P{L}]+"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void getLongWordCountBench() {
		long start = System.nanoTime();
		wordList.stream().filter(w -> w.length() > minWordLength).count();
		long end = System.nanoTime();
		System.out.println("stream:         " + (end - start));
	}

	public void getLongWordCountParallelBench() {
		long start = System.nanoTime();
		wordList.parallelStream().filter(w -> w.length() > minWordLength).count();
		long end = System.nanoTime();
		System.out.println("parallelStream: " + (end - start));
	}

	public static void main(String[] args) {
		ParallelStreamBench psb = new ParallelStreamBench(".\\src\\ch02\\ex03\\WarAndPeace.txt");
		psb.getLongWordCountBench();
		psb.getLongWordCountParallelBench();
	}
}
