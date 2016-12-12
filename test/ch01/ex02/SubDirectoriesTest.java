package ch01.ex02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class SubDirectoriesTest {

	@Test
	public void testGetSubDirectoriesLambda() {
		int count = 0;
		String currentDir = new File(".").getAbsolutePath() + File.separator + "test" + File.separator + "ch01" + File.separator + "ex02";
		String test1Name = "test1";
		String test1 = currentDir + File.separator + test1Name;
		String test2 = currentDir + File.separator + "test2";
		String subTest1 = currentDir + File.separator + test1Name + File.separator + "subTest1";
		new File(test1).mkdir();
		new File(test2).mkdir();
		new File(subTest1).mkdir();
		List<File> list = new SubDirectories().getSubDirectoriesLambda(new File(currentDir));
		for (File file : list) {
			if (test1.equals(file.getAbsolutePath()) || test2.equals(file.getAbsolutePath()) || subTest1.equals(file.getAbsolutePath()))
				count++;
		}
		assertEquals(3, count);
	}

	@Test
	public void testGetSubDirectoriesMethod() {
		int count = 0;
		String currentDir = new File(".").getAbsolutePath() + File.separator + "test" + File.separator + "ch01" + File.separator + "ex02";
		String test1Name = "test1";
		String test1 = currentDir + File.separator + test1Name;
		String test2 = currentDir + File.separator + "test2";
		String subTest1 = currentDir + File.separator + test1Name + File.separator + "subTest1";
		new File(test1).mkdir();
		new File(test2).mkdir();
		new File(subTest1).mkdir();
		List<File> list = new SubDirectories().getSubDirectoriesMethod(new File(currentDir));
		for (File file : list) {
			if (test1.equals(file.getAbsolutePath()) || test2.equals(file.getAbsolutePath()) || subTest1.equals(file.getAbsolutePath()))
				count++;
		}
		assertEquals(3, count);
	}

}
