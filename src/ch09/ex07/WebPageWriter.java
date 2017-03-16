package ch09.ex07;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class WebPageWriter {
	public static void main(String[] args) throws IOException {
		String filePath = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex07" + File.separator + "out.txt";
		String url = "http://www.ricoh.co.jp/";
		try (InputStream stream = new URL(url).openStream()) {
		    Files.copy(stream, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
		}
		System.out.println("End.");
    }
}
