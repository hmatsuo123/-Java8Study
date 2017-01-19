package ch06.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordLoader {
	public static Map<String, Set<File>> getWords(List<File> files) {
		ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();
		ExecutorService pool = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(files.size());

		for (File file : files) {
			pool.submit(
					() -> {
						try {
							String contents = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
							List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
							for (String word : words) {
								Set<File> set = new HashSet<File>();
								set.add(file);
								map.merge(word, set, (existingValue, newValue) -> {
									Set<File> newSet = new HashSet<File>();
									newSet.addAll(existingValue);
									newSet.addAll(newValue);
									return newSet;
								});
							}

						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						latch.countDown();
					}
					);
		}
		pool.shutdown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		String filePath = "." + File.separator + "src" + File.separator + "ch06" + File.separator + "ex05" + File.separator + "WarAndPeace.txt";
		String filePath2 = "." + File.separator + "src" + File.separator + "ch06" + File.separator + "ex05" + File.separator + "test.txt";
		Map<String, Set<File>> map = WordLoader.getWords(Arrays.asList(new File(filePath), new File(filePath2)));
		System.out.println("Word Count: " + map.size());
		map.keySet().stream().limit(10).forEach(System.out::println);
	}
}
