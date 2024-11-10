package leet;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import leet.backtrack.Permutation;

public class PermutationTest {

    private Permutation permutation;

    @Before
    public void prepare() {
        permutation = new Permutation();
    }

    @Test
    public void permute() {
        int[] nums = {1, 2, 3};
//        List<List<Integer>> result = List.of(List.of(1, 2, 3), List.of(1, 3, 2)
//                , List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
        List<List<Integer>> permutations = permutation.permute(nums);
        System.out.println(permutations);
    }
}