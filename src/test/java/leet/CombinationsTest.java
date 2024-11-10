package leet;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import leet.backtrack.Combinations;

public class CombinationsTest {

    private Combinations combinations;

    @Before
    public void prepare() {
        combinations = new Combinations();
    }

    @Test
    public void combine() {
        List<List<Integer>> combine = combinations.combine(4, 2);
        for (List<Integer> innerList : combine) {
            System.out.println(innerList);
        }
    }
}