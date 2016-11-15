package ch01.ex04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class DirectoryComparetorTest {

	@Test
	public void testDirCompare() {
		File[] files = new File[]{
				new File(".\\test\\ch01\\ex04\\test\\dir2"), new File(".\\test\\ch01\\ex04\\test\\file2"), new File(".\\test\\ch01\\ex04\\test\\dir1"), new File(".\\test\\ch01\\ex04\\test\\file1")
		};
		List<File> fileList = new DirectoryComparetor().dirCompare(files);
		assertEquals("dir1", fileList.get(0).getName());
		assertEquals("dir2", fileList.get(1).getName());
		assertEquals("file1", fileList.get(2).getName());
		assertEquals("file2", fileList.get(3).getName());
	}

}
