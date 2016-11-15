package ch01.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class SubDirectories {
	public List<File> getSubDirectoriesLambda(File file) {
		List<File> list = new ArrayList<File>();
		File[] files = file.listFiles(f -> f.isDirectory());
		for (int i = 0; i < files.length; i++) {
			list.add(files[i]);
			getSubDirectoriesLambda(files[i]);
		}
		return list;
	}

	public List<File> getSubDirectoriesMethod(File file) {
		List<File> list = new ArrayList<File>();
		File[] files = file.listFiles(File::isDirectory);
		for (int i = 0; i < files.length; i++) {
			list.add(files[i]);
			getSubDirectoriesMethod(files[i]);
		}
		return list;
	}

	public static void main(String[] args) {
		File dir = new File(".\\src\\ch01");
		List<File> list = new SubDirectories().getSubDirectoriesMethod(dir);
		for (File file : list) {
			System.out.println(file);
		}
	}
}
