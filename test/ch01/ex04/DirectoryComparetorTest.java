package ch01.ex04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class DirectoryComparetorTest {

	@Test
	public void testDirCompare() {
		File[] files = new File[]{
				new File("." + File.separator + "test" + File.separator + "ch01" + File.separator + "ex04" + File.separator + "test" + File.separator + "dir2"),
				new File("." + File.separator + "test" + File.separator + "ch01" + File.separator + "ex04" + File.separator + "test" + File.separator + "file2"),
				new File("." + File.separator + "test" + File.separator + "ch01" + File.separator + "ex04" + File.separator + "test" + File.separator + "dir1"),
				new File("." + File.separator + "test" + File.separator + "ch01" + File.separator + "ex04" + File.separator + "test" + File.separator + "file1")
		};
		List<File> fileList = new DirectoryComparetor().dirCompare(files);
		assertEquals("dir1", fileList.get(0).getName());
		assertEquals("dir2", fileList.get(1).getName());
		assertEquals("file1", fileList.get(2).getName());
		assertEquals("file2", fileList.get(3).getName());
	}

}
