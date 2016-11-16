package ch02.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class ParallelForLoop {

	private final int minWordLength = 3;
	private final int listSegment = 3;
	private int segmentCount = 0;
	private int sum = 0;
	private Object sumLock = new Object();

	// 文字でないもので単語を分割し、minWordLengthより長い単語数を返す
	public int getLongWordCount(String contents) {
		sum = 0;
		List<String> wordList = Arrays.asList(contents.split("\\P{L}+"));
		while (true) {
			if (segmentCount < wordList.size()) {
				int startIdx = segmentCount;
				segmentCount += listSegment;
				Stream<String> words = Stream.of(contents.split("\\P{L}+")).limit(segmentCount).skip(startIdx);

				Thread thread = new Thread(() -> {
					long count = words.filter(word -> word.length() > minWordLength).count();
					synchronized (sumLock) {
						sum += count;
					}
				});
				thread.start();

				if (segmentCount == wordList.size()) {
					try {
						thread.join();
					} catch (InterruptedException e) {
						System.err.println(e);
					} finally {
						// 最後の計算が終了したら合計値を返す
						break;
					}
				}
			} else {
				int startIdx = segmentCount;
				int endIdx = wordList.size() - segmentCount;
				Stream<String> words = Stream.of(contents.split("\\P{L}+")).limit(endIdx).skip(startIdx);

				Thread thread = new Thread(() -> {
					long count = words.filter(word -> word.length() > minWordLength).count();
					synchronized (sumLock) {
						sum += count;
					}
				});
				thread.start();

				try {
					thread.join();
				} catch (InterruptedException e) {
					System.err.println(e);
				} finally {
					// 最後の計算が終了したら合計値を返す
					break;
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		ParallelForLoop pfl = new ParallelForLoop();
		int sum = pfl.getLongWordCount("test1test2tt");
		System.out.println(sum);
	}
}
