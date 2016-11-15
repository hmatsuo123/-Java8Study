package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DirectoryComparetor {

	public List<File> dirCompare(File[] files) {
		Arrays.sort(files, (File f1, File f2) -> {
			if (f1.isDirectory() && !f2.isDirectory()) {
				return -1;
			} else if (!f1.isDirectory() && f2.isDirectory()) {
				return 1;
			} else {
				return f1.getName().compareTo(f2.getName());
			}
		});

		return Arrays.asList(files);
	}

	public static void main(String[] args) {
		File[] files = new File[]{
				new File(".\\src\\ch01\\ex04"), new File(".\\src\\ch01\\ex02"), new File(".\\src\\ch01\\ex04\\DirectoryComparetor.java"), new File(".\\src\\ch01\\ex01")
		};
		System.out.println("Befor");
		Arrays.asList(files).forEach(file -> {
			System.out.println("\t" + file.getName());
		});

		List<File> fileList = new DirectoryComparetor().dirCompare(files);
		System.out.println("After");
		fileList.forEach(file -> {
			System.out.println("\t" + file.getName());
		});
	}
}
