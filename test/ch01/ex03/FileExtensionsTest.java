package ch01.ex03;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class FileExtensionsTest {

	/*@Before
	public static void setUpBeforeClass() throws Exception {
		String currentDir = new File(".").getAbsolutePath() + "\\test\\ch01\\ex03\\test";
		File file = new File(currentDir);
		if (!file.isDirectory())
			// テスト環境の作成に失敗した場合、テストを実行しない
			org.junit.Assume.assumeTrue(file.mkdir());

		List<String> fileNameList = Arrays.asList(new String[]{ "first.txt", "second.text", "dummy.java" });
		fileNameList.forEach(fileName -> {
			if (!new File(fileName).exists())
				// テスト環境の作成に失敗した場合、テストを実行しない
				org.junit.Assume.assumeTrue(file.mkdir());
		});
	}*/

	@Test
	public void testGetFileListByExtension() {
		List<String> list = new FileExtensions().getFileListByExtension("." + File.separator + "test" + File.separator + "ch01" + File.separator + "ex03" + File.separator + "test", ".txt");
		assertEquals(2, list.size());
	}

}
