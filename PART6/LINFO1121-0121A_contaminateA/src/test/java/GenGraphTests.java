import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenGraphTests {
    @Test
    public void test0() {
        assertEquals(ExampleGraphs.convertedEx0, Contaminate.genGraph(Helper.makeImmutable(ExampleGraphs.ex0)));
    }
    
    @Test
    public void test1() {
        assertEquals(ExampleGraphs.convertedEx1, Contaminate.genGraph(Helper.makeImmutable(ExampleGraphs.ex1)));
    }

    @Test
    public void test2() {
        assertEquals(ExampleGraphs.convertedEx2, Contaminate.genGraph(Helper.makeImmutable(ExampleGraphs.ex2)));
    }

    @Test
    public void test3() {
        assertEquals(ExampleGraphs.convertedEx3, Contaminate.genGraph(Helper.makeImmutable(ExampleGraphs.ex3)));
    }

    @Test
    public void test4() {
        assertEquals(ExampleGraphs.convertedEx4, Contaminate.genGraph(Helper.makeImmutable(ExampleGraphs.ex4)));
    }

    @Test
    public void test5() {
        assertEquals(ExampleGraphs.convertedEx5, Contaminate.genGraph(Helper.makeImmutable(ExampleGraphs.ex5)));
    }
}
