package leet;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;

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


}