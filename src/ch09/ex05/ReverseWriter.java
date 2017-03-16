package ch09.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseWriter {
	public static void main(String[] args) {
		String filePath = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex01" + File.separator + "WarAndPeace.txt";
        String filePath2 = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex05" + File.separator + "out.txt";
        try {
            byte[] source = Files.readAllBytes(Paths.get(filePath));
            StringBuilder content = new StringBuilder(new String(source, StandardCharsets.UTF_8));
            content.reverse();
            Files.write(Paths.get(filePath2), content.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        System.out.println("End.");
    }
}
