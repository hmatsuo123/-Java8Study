package ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MyComparator {

	public static Comparator<String> createAscendingComparator(boolean ignoreUpperOrLowerCase, boolean excludeWhitespace) {
        return (s1, s2) -> {
            String target1 = excludeWhitespace ? s1.replaceAll(" ", "") : s1;
            String target2 = excludeWhitespace ? s2.replaceAll(" ", "") : s2;
            return ignoreUpperOrLowerCase ? target1.compareTo(target2) : target1.compareToIgnoreCase(target2);
        };
    }

	public static Comparator<String> createDescendingComparator(boolean ignoreUpperOrLowerCase, boolean excludeWhitespace) {
        return (s1, s2) -> {
        	String target1 = excludeWhitespace ? s1.replaceAll(" ", "") : s1;
            String target2 = excludeWhitespace ? s2.replaceAll(" ", "") : s2;
            return -(ignoreUpperOrLowerCase ? target1.compareTo(target2) : target1.compareToIgnoreCase(target2));
        };
    }

	public static void main(String[] args) {
		String[] test = {"1", "5", "3", "a", "C", " bb"};
		Arrays.sort(test, MyComparator.createDescendingComparator(false, true));
        Stream.of(test).forEach(System.out::println);
	}
}
