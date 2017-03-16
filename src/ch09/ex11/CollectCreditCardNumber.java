package ch09.ex11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectCreditCardNumber {
	public static void main(String[] args) {
        String path = System.getProperty("user.home");
        //String path = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex09" + File.separator + "test.txt";
        String reg = "\"[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]\"";
        //ProcessBuilder builder = new ProcessBuilder("findstr", "-s", reg, path);
        ProcessBuilder builder = new ProcessBuilder("grep", "/s", reg, path);
        String outputPath = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex01" + File.separator + "out.txt";
        Path output= Paths.get(outputPath);
        builder.redirectOutput(output.toFile());

        try {
            Process process = builder.start();
            process.waitFor();

            List<String> lines = Files.readAllLines(output);
            Set<String> result = new HashSet<String>();
            lines.stream().forEach(line -> {
                result.add(line);
            });

            result.forEach(System.out::println);
        } catch (IOException | InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("End.");
    }
}
