import com.github.guillaumederval.javagrading.Grade;
import dontreadthis.RBTChecker;
import dontreadthis.TreeTwoThree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import structures.RBNode;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ConverterTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection genKeys() {
        return Arrays.asList(new Object[][] {
                { "Ex1", new String[] {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"} },
                { "Ex2", new String[] {"I", "N", "G", "O", "U", "S", "P", "E", "R", "F", "C", "T"} },
                { "AllBlack", new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"} }, //all black
                { "Ex3", new String[] {"E", "A", "I", "M", "D", "F", "L", "G", "B", "K", "H", "C", "J"} }
        });
    }


    String[] keys;
    public ConverterTest(String ignore, String[] keys) {
        this.keys = keys;
    }

    private RBTChecker<String, Integer> runAndGetChecker() {
        // Create a 2-3 tree
        TreeTwoThree<String, Integer> ttt = new TreeTwoThree<>();
        for(int i = 0; i < keys.length; i++)
            ttt.insert(keys[i], i);

        RBNode<String, Integer> rbt =  Converter.convert(ttt.getRoot());

        assertNotNull(rbt);

        return new RBTChecker<>(rbt);
    }

    @Test
    public void checkContent() {
        checkKeys(runAndGetChecker().keys(), keys);
    }

    @Test
    public void checkBST() {
        RBTChecker<String, Integer> checker = runAndGetChecker();
        //checkKeys(checker.keys(), keys); //verified on INGInious!
        assertTrue(checker.isBST());
    }

    @Test
    public void check23() {
        RBTChecker<String, Integer> checker = runAndGetChecker();
        //checkKeys(checker.keys(), keys); //verified on INGInious!
        assertTrue(checker.is23());
    }

    @Test
    public void checkSize() {
        RBTChecker<String, Integer> checker = runAndGetChecker();
        //checkKeys(checker.keys(), keys); //verified on INGInious!
        assertTrue(checker.isSizeConsistent());
    }

    @Test
    public void checkBalanced() {
        RBTChecker<String, Integer> checker = runAndGetChecker();
        //checkKeys(checker.keys(), keys); //verified on INGInious!
        assertTrue(checker.isBalanced());
    }

    public <Key extends Comparable<Key>> void checkKeys(Iterable<Key> treeItr, Key[] array) {
        TreeSet<Key> content = new TreeSet<>();
        for(Key k: treeItr) {
            assertFalse(content.contains(k));
            content.add(k);
        }
        for(Key k: array) {
            assertTrue(content.contains(k));
            content.remove(k);
        }
        assertTrue(content.isEmpty());
    }
}

