package ch06.ex07;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MaxKeySearcher {
	public static String searchMaxKey(ConcurrentHashMap<String, Long> map) {
        return map.reduceEntries(1, (v1, v2) -> v1.getValue() > v2.getValue() ? v1 : v2).getKey();
    }

	public static void main(String[] args) {
		String filePath = "." + File.separator + "src" + File.separator + "ch06" + File.separator + "ex07" + File.separator + "WarAndPeace.txt";
		try {
			String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
			words.stream().forEach(x -> {map.put(x, (long)x.length());});
			System.out.println(MaxKeySearcher.searchMaxKey(map));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
