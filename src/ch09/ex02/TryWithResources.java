package ch09.ex02;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResources {
	private static Throwable original = null;

    public static void write(String sourceFilePath, String destinationFilePath) throws Throwable{
    	Scanner in = null;
        PrintWriter out = null;
    	try {
            in = new Scanner(Paths.get(sourceFilePath));
            in.useDelimiter("//.*\n");
            out = new PrintWriter(destinationFilePath);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Throwable e) {
        	e.printStackTrace();
        	original = e;
        	throw e;
        } finally {
        	try {
                in.close();
            } catch (Throwable e) {
            	e.printStackTrace();
            	if (original != null) {
                    original.addSuppressed(e);
                }
            }
        	try {
                out.close();
            } catch (Throwable e) {
            	e.printStackTrace();
            	if (original != null) {
                    original.addSuppressed(e);
                }
            }
        }
        System.out.println("End.");
    }

    public static void main(String[] args) throws Throwable{
        String filePath = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex01" + File.separator + "WarAndPeace.txt";
        String filePath2 = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex02" + File.separator + "out.txt";
        write(filePath, filePath2);
    }
}
