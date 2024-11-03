package leet;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import leet.twoPointer.TwoSum;


/**
 * @author alireza_bayat
 * created on 3/26/22
 */
public class TwoSumTest {

    TwoSum twoSum;

    @Before
    public void setup() {
        twoSum = new TwoSum();
    }

    @Test
    public void twoSum() {
        System.out.println(LocalDateTime.now());
        int[] sampleArray = {-1, -2, -3, -4, -5};
        Arrays.stream(twoSum.twoSumFirstSolution(sampleArray, -8)).forEach(System.out::print);
        System.out.println();
        System.out.println(LocalDateTime.now());
    }


    @Test
    public void twoSum_2() {
        System.out.println(LocalDateTime.now());
        int[] sampleArray = {-1, -2, -3, -4, -5};
        Arrays.stream(twoSum.twoSum(sampleArray, -8)).forEach(System.out::print);
        System.out.println();
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void twoSumII() {
        System.out.println(LocalDateTime.now());
        int[] sampleArray = {2, 7, 11, 15};
        Arrays.stream(twoSum.twoSumII(sampleArray, 9)).forEach(System.out::print);
        System.out.println();
        System.out.println(LocalDateTime.now());
    }

}