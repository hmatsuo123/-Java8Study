package ch06.ex01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class MyAtomicReference {
	public static String getLongestWord(List<File> files) {
        AtomicReference<String> longestWord = new AtomicReference<>("");
        ExecutorService pool = Executors.newCachedThreadPool();

        for (File file : files) {
			pool.submit(
					() -> {
						try {
							String contents = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
							List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
							words.forEach(w -> longestWord.accumulateAndGet(w, (w1, w2) ->
		                    w1.length() > w2.length() ? w1 : w2));

						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					}
					);
		}
		pool.shutdown();
		try {
			pool.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return longestWord.get();
    }

	public static void main(String[] args) {
		String filePath = "." + File.separator + "src" + File.separator + "ch06" + File.separator + "ex05" + File.separator + "WarAndPeace.txt";
		String filePath2 = "." + File.separator + "src" + File.separator + "ch06" + File.separator + "ex05" + File.separator + "test.txt";
		System.out.println(MyAtomicReference.getLongestWord(Arrays.asList(new File(filePath), new File(filePath2))));
	}
}
