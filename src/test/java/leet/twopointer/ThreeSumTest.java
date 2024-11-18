package leet.twopointer;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ThreeSumTest {


    ThreeSum threeSum;

    @Before
    public void prepare() {
        threeSum = new ThreeSum();
    }

    @Test
    public void threeSum() {
        int[] first = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        List<List<Integer>> lists = threeSum.threeSum(first);

        System.out.println("done print array");
    }

}