package leet.graph;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EvaluateDivisionTest {

    private EvaluateDivision evaluateDivision;

    @Before
    public void prepare() {
        evaluateDivision = new EvaluateDivision();
    }

    @Test
    public void calcEquation() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );

        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] results = evaluateDivision.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results));
    }
}