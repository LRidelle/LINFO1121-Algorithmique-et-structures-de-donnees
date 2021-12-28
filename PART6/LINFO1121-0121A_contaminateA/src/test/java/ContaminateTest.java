import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ContaminateTest {
    private static void checkAnswer(Map<String, Set<String>> data, String[] from, int[] answer) {
        data = Helper.makeImmutable(data);
        for(int i = 0; i < from.length; i++) {
            assertEquals("Pour "+from[i], answer[i], Contaminate.minTime(from[i], data));
        }
    }

    @Test
    public void testEx0() {
        Map<String, Set<String>> data = ExampleGraphs.ex0;
        String[] from = new String[]{"Didier", "Frederic", "Emmanuel", "Bob", "Jacky"};
        int[] answer = new int[]{2, 2, 1, 2, 2};
        checkAnswer(data, from, answer);
    }

    @Test
    public void testEx1() {
        Map<String, Set<String>> data = ExampleGraphs.ex1;
        String[] from = new String[]{"Frederic", "Charles", "Bob", "Didier", "Isidore", "Emmanuel", "Guillaume", "Jacky", "Henry"};
        int[] answer = new int[]{2, 2, 2, 2, 3, 2, 2, 3, 3};
        checkAnswer(data, from, answer);
    }

    @Test
    public void testEx2() {
        Map<String, Set<String>> data = ExampleGraphs.ex2;
        String[] from = new String[]{"Frederic", "Charles", "Bob", "Alice", "Didier", "Emmanuel", "Guillaume", "Jacky", "Henry"};
        int[] answer = new int[]{2, 3, 4, 3, 3, 4, 3, 4, 4};
        checkAnswer(data, from, answer);
    }

    @Test
    public void testEx3() {
        Map<String, Set<String>> data = ExampleGraphs.ex3;
        String[] from = new String[]{"Frederic", "Bob", "Alice", "Didier", "Isidore", "Emmanuel", "Guillaume", "Jacky", "Henry"};
        int[] answer = new int[]{3, 4, 3, 3, 3, 2, 3, 4, 3};
        checkAnswer(data, from, answer);
    }

    @Test
    public void testEx4() {
        Map<String, Set<String>> data = ExampleGraphs.ex4;
        String[] from = new String[]{"Frederic", "Charles", "Bob", "Alice", "Didier", "Isidore", "Emmanuel", "Guillaume", "Jacky", "Henry"};
        int[] answer = new int[]{5, 7, 8, 9, 6, 8, 5, 6, 9, 7};
        checkAnswer(data, from, answer);
    }

    @Test
    public void testEx5() {
        Map<String, Set<String>> data = ExampleGraphs.ex5;
        String[] from = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int[] answer = new int[]{3, 4, 4, 4, 2, 3, 4, 4, 3, 4};
        checkAnswer(data, from, answer);
    }
}
