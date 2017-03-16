package ch09.ex06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReverseLineWriter {
	public static void main(String[] args) {
		String filePath = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex01" + File.separator + "WarAndPeace.txt";
        String filePath2 = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex06" + File.separator + "out.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            Collections.reverse(lines);
            Files.write(Paths.get(filePath2), lines);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        System.out.println("End.");
    }
}
