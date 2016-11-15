package ch01.ex03;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExtensions {

	public List<String> getFileListByExtension(String dirPath, String extension) {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(dirPath);
			if (!file.isDirectory())
				throw new IllegalArgumentException("第一引数にはディレクトリパスを指定してください。:" + dirPath);

			String[] files = file.list((dir, name) -> {
				return name.endsWith(extension);
			});

			list = Arrays.asList(files);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> list = new FileExtensions().getFileListByExtension(".\\src\\ch01\\ex03", ".java");
		list.forEach(System.out::println);
	}
}
