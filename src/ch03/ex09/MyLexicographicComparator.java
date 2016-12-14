package ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class MyLexicographicComparator {

	public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
        return (first, second) -> {
            for (String fieldName : fieldNames) {
                Comparable<?> firstValue = null;
                Comparable<?> secondValue = null;

                try {
                    Field firstField = first.getClass().getField(fieldName);
                    firstField.setAccessible(true);
                    firstValue = (Comparable<?>)firstField.get(first);
                    Field secondField = second.getClass().getField(fieldName);
                    secondField.setAccessible(true);
                    secondValue = (Comparable<?>)secondField.get(second);
                } catch (Exception e) {
                	e.printStackTrace();
                    break;
                }

                if (firstValue != null && secondValue != null) {
					@SuppressWarnings("unchecked")
					int compare = ((Comparable)firstValue).compareTo(secondValue);
                    if (compare != 0) {
                        return compare;
                    }
                }
            }

            // フィールド値の取得に失敗した場合、とりあえず0を返す
            return 0;
        };
    }

	public static void main(String[] args) {
		Comparator<TestClass> comparator = MyLexicographicComparator.lexicographicComparator("lastName", "firstName");
		System.out.println(comparator.compare(new TestClass("first", "second"), new TestClass("first", "second")));
		System.out.println(comparator.compare(new TestClass("first", "second"), new TestClass("first2", "second")));
		System.out.println(comparator.compare(new TestClass("first", "second"), new TestClass("1", "2")));
	}
}
